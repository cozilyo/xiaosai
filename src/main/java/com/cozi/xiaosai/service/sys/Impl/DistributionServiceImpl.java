package com.cozi.xiaosai.service.sys.Impl;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.mapper.dataOrigin.sys.DistributionMapper;
import com.cozi.xiaosai.pojo.dataorigin.sys.MenuInfoPojo;
import com.cozi.xiaosai.pojo.dataorigin.sys.NavigationBarPojo;
import com.cozi.xiaosai.pojo.dataorigin.sys.SidebarPojo;
import com.cozi.xiaosai.service.sys.DistributionService;
import com.cozi.xiaosai.util.redis.RedisPrefix;
import com.cozi.xiaosai.util.redis.RedisUtils;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */
@Service
public class DistributionServiceImpl implements DistributionService {

    @Autowired
    private DistributionMapper distributionMapper;

    @Autowired
    private RedisUtils redisUtils;

    private List<MenuInfoPojo> listMenu = new ArrayList<>();

    @Override
    public R getSidebarInfo() {
        Gson gson = new Gson();
        //如果缓存中存在，直接从缓存中获取
        List<Map<String, Object>> Listdata = (List<Map<String, Object>>)gson.fromJson((String) redisUtils.get(RedisPrefix.BAR.getPrefix(), 2),List.class);
        if(Listdata!=null&&Listdata.size()>0){
            return R.isOk().data(Listdata);
        }
        List<NavigationBarPojo> navigationBarPojos = distributionMapper.selectNavigationBar();
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < navigationBarPojos.size(); i++) {
            Map<String, Object> sideBar = new HashMap<>();
            List<SidebarPojo> sidebarPojo = barConstruction(0, navigationBarPojos.get(i).getId());
            sideBar.put(navigationBarPojos.get(i).getNavigationBarName(), sidebarPojo);
            list.add(sideBar);
        }
        //缓存侧边栏信息
        redisUtils.set(RedisPrefix.BAR.getPrefix(),gson.toJson(list),2);

        return R.isOk().data(list);
    }

    @Override
    public R getMenuInfo() {
       /* Gson gson = new Gson();
        List<MenuInfoPojo> listCache = gson.fromJson((String)redisUtils.get(RedisPrefix.MENU.getPrefix(), 2),List.class);
        if(listCache!=null&&listCache.size()>0){
            return R.isOk().data(listCache);
        }*/

        //每次重新获取，清空集合
        listMenu.clear();
        List<NavigationBarPojo> navigationBarPojos = distributionMapper.selectNavigationBar();
        System.out.println(navigationBarPojos);
        //获取导航栏
        if(navigationBarPojos!=null&&navigationBarPojos.size()>0){
            List<MenuInfoPojo> menuInfoPojos = distributionMapper.selectMenuInfoList();
            for(NavigationBarPojo navigationBarPojo:navigationBarPojos){
                menuConstruction(menuInfoPojos,navigationBarPojo.getNavigationBarName(),0,navigationBarPojo.getId());
            }
            for(int i=1;i<=listMenu.size();i++){
                listMenu.get(i-1).setAuthorityId(i);
            }
        }

        //redisUtils.set(RedisPrefix.MENU.getPrefix(),gson.toJson(listMenu),2);

        return R.isOk().data(listMenu).count(listMenu.size());
    }

    @Override
    public MenuInfoPojo getmenuEditData(Integer id) {
        return distributionMapper.selectmenuEditData(id);
    }

    @Override
    public R editMenuData(MenuInfoPojo menuInfoPojo) {
        return R.isOk().msg("菜单管理编辑成功");
    }

    @Override
    public R addMenuData(MenuInfoPojo menuInfoPojo) {
        if(StringUtils.isEmpty(menuInfoPojo.getNavigationBarName())||distributionMapper.selectCountByMenuInfoPojo(new MenuInfoPojo(menuInfoPojo.getNavigationBarName()),1,2)>0){
            if(menuInfoPojo.getNavId().intValue()<=0||distributionMapper.selectCountByMenuInfoPojo(new MenuInfoPojo(menuInfoPojo.getNavId(),menuInfoPojo.getNavigationBarName()),1,1)<=0){
                R.isFail().msg("导航id无效或与导航标识不一致！");
            }
        }
        if(StringUtils.isEmpty(menuInfoPojo.getTitle())||distributionMapper.selectCountByMenuInfoPojo(new MenuInfoPojo(menuInfoPojo.getTitle(),menuInfoPojo.getParentId()),2,1)>0){
            return R.isFail().msg("侧边栏名称不能为空或同级重复!");
        }

        //导航栏已存在
        if(StringUtils.isNotEmpty(menuInfoPojo.getNavigationBarName())&&distributionMapper.selectCountByMenuInfoPojo(new MenuInfoPojo(menuInfoPojo.getNavigationBarName()),1,2)>0){
            distributionMapper.insertSidebar(menuInfoPojo);
        //导航不存在
        }else {
            menuInfoPojo.setNavigationBarIndex(distributionMapper.selectMixIndex()+1);
            distributionMapper.insertNavigationBar(menuInfoPojo);
            menuInfoPojo.setNavId(menuInfoPojo.getId());
            distributionMapper.insertSidebar(menuInfoPojo);
        }
        return null;
    }

    /**
     *构造菜单结构信息
     * @param list 所有数据
     * @param navigationBarName
     * @param parentId
     * @param navId
     * @return
     */
    public List<MenuInfoPojo> menuConstruction(List<MenuInfoPojo> list,String navigationBarName,Integer parentId,Integer navId){
        for(MenuInfoPojo menuInfoPojo:list){
            if(navigationBarName.equals(menuInfoPojo.getNavigationBarName())&&parentId.equals(menuInfoPojo.getParentId())&&navId.equals(menuInfoPojo.getNavId())){
                if(!listMenu.contains(menuInfoPojo)){
                    listMenu.add(menuInfoPojo);
                }
                menuConstruction(list,menuInfoPojo.getNavigationBarName(),menuInfoPojo.getId(),menuInfoPojo.getNavId());
            }
        }
        return listMenu;
    }

    /**
     * 构造侧边栏信息
     *
     * @param parentId
     * @param navId
     * @return
     */
    public List<SidebarPojo> barConstruction(Integer parentId, Integer navId) {
        List<SidebarPojo> sidebarPojos = distributionMapper.selectSidebar(parentId, navId);
            if (sidebarPojos.size() > 0) {
                for (SidebarPojo sidebarPojo1 : sidebarPojos) {
                    List<SidebarPojo> sidebarPojos1 = barConstruction(sidebarPojo1.getId(), navId);
                    sidebarPojo1.setChild(sidebarPojos1);
                }
            }
        return sidebarPojos;
    }

}