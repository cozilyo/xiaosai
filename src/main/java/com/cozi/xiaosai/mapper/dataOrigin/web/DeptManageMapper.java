package com.cozi.xiaosai.mapper.dataOrigin.web;

import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.cozi.xiaosai.pojo.dataorigin.web.DeptManagePojo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public interface DeptManageMapper {

    List<DeptManagePojo> selectDept();

    Page<User> selectUserByDeptIds(@Param("_ids") String _ids);

}
