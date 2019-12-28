package com.cozi.xiaosai.util;

import com.cozi.xiaosai.util.redis.RedisUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
@SpringBootTest
public class RedisTests {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void test(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("sdf","fsdaf");
        map.put("fsda","fdsa");
        list.add(map);
        redisUtils.set("dffa",list,3);
    }

}
