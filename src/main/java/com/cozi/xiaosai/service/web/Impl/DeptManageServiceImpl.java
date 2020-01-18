package com.cozi.xiaosai.service.web.Impl;

import com.cozi.xiaosai.common.PageFormatConver;
import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.enums.CueWordsEnum;
import com.cozi.xiaosai.mapper.dataOrigin.web.DeptManageMapper;
import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.cozi.xiaosai.pojo.dataorigin.sysParams.UserParams;
import com.cozi.xiaosai.pojo.dataorigin.web.DeptManagePojo;
import com.cozi.xiaosai.service.web.DeptManageService;
import com.cozi.xiaosai.util.redis.RedisKey;
import com.cozi.xiaosai.util.redis.RedisUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */
@Service
public class DeptManageServiceImpl implements DeptManageService {

    @Autowired
    private DeptManageMapper deptManageMapper;

    @Autowired
    private RedisUtils redisUtils;

    private List<Integer> idsList = new ArrayList<>();

    @Override
    public R getDeptManageData() {
        //redis缓存
        List<DeptManagePojo> deptManagePojosList = (List<DeptManagePojo>) redisUtils.get(RedisKey.DEPTTREE.getKey());
        if(deptManagePojosList!=null&&deptManagePojosList.size()>0){
            return R.isOk().data(deptManagePojosList).msg(CueWordsEnum.DEPT_MANAGE_SUCCESS.getValue());
        }
        List<DeptManagePojo> deptManagePojos = deptManageMapper.selectDept();
        List<DeptManagePojo> list = new ArrayList<>();
        if(deptManagePojos.size()>0){
            for(DeptManagePojo deptManagePojo:deptManagePojos){
                if(deptManagePojo.getDeptParentId().equals(0)){
                    DeptManagePojo deptManagePojo1 = recursiveSearchDept(deptManagePojo, deptManagePojos);
                    deptManagePojo1.setSpread(true);
                    list.add(deptManagePojo1);
                }
            }
            redisUtils.set(RedisKey.DEPTTREE.getKey(),list);
            return R.isOk().data(list).msg(CueWordsEnum.DEPT_MANAGE_SUCCESS.getValue());
        }else {
            return R.isFail().msg(CueWordsEnum.DEPT_MANAGE_FAILED.getValue());
        }
    }

    @Override
    public R getDeptToUser(UserParams userParams) {
        if(!(userParams.getDeptId()!=null&&userParams.getDeptId().intValue()>0)){
            userParams.setDeptId(1);
        }
        if(userParams.getDeptId()!=null&&userParams.getDeptId().intValue()>0){
            //清空idsList
            idsList.clear();
            //添加当前节点
            idsList.add(userParams.getDeptId());
            List<DeptManagePojo> deptManagePojos = deptManageMapper.selectDept();
            List<Integer> integers = searchUserId(deptManagePojos, userParams.getDeptId());
            String _ids = integers.toString().substring(1, integers.toString().length()-1);
            //通过部门id获取人员信息
            PageHelper.startPage(userParams.getPage(),userParams.getLimit());
            PageInfo<User> userPageInfo = new PageInfo<User>(deptManageMapper.selectUserByDeptIds(_ids));
            return new PageFormatConver(userPageInfo).isOK();
        }
        return R.isFail().msg(CueWordsEnum.DEPT_MANAGE_FAILED_TO_USER.getValue());
    }

    /**
     * 递归查找部门信息
     * @param deptManagePojoParam
     * @param deptManagePojos
     * @return
     */
    public DeptManagePojo  recursiveSearchDept(DeptManagePojo deptManagePojoParam,List<DeptManagePojo> deptManagePojos){
        List<DeptManagePojo> list1 = new ArrayList<>();
        for(DeptManagePojo deptManagePojo:deptManagePojos){
            if(deptManagePojo.getDeptParentId().equals(deptManagePojoParam.getId())){
                DeptManagePojo deptManagePojo1 = recursiveSearchDept(deptManagePojo, deptManagePojos);
                list1.add(deptManagePojo1);
            }
        }
        deptManagePojoParam.setChildren(list1);
        return deptManagePojoParam;
    }

    /**
     * 递归查找本部门及其子部门
     * @param deptManagePojos
     * @param id
     * @return
     */
    public List<Integer> searchUserId(List<DeptManagePojo> deptManagePojos,Integer id){
        for(DeptManagePojo deptManagePojo:deptManagePojos){
            if(deptManagePojo.getDeptParentId().equals(id)){
                searchUserId(deptManagePojos,deptManagePojo.getId());
                idsList.add(deptManagePojo.getId());
            }
        }
        return idsList;
    }

}
