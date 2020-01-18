package com.cozi.xiaosai.web;

import com.cozi.xiaosai.pojo.dataorigin.sysParams.UserParams;
import com.cozi.xiaosai.service.web.DeptManageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */
@SpringBootTest
public class DeptManageServiceTests {

    @Autowired
    private DeptManageService deptManageService;

    @Test
    public void test(){
        //deptManageService.getDeptManageData();
        //System.out.println(deptManageService.getDeptManageData());
        UserParams userParams = new UserParams();
        userParams.setDeptId(1);
        userParams.setPage(1);
        userParams.setLimit(20);
        System.out.println(deptManageService.getDeptToUser(userParams));
    }
}
