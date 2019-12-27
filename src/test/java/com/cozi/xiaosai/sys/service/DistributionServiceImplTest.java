package com.cozi.xiaosai.sys.service;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.service.sys.DistributionService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */
@SpringBootTest
public class DistributionServiceImplTest {

    @Autowired
    private DistributionService distributionService;

    @Test
    public void test(){
        System.out.println(new Gson().toJson(distributionService.getSidebarInfo()));
    }

}
