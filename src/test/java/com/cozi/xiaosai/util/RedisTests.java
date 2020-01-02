package com.cozi.xiaosai.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

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

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
       /* List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("sdf","fsdaf");
        map.put("fsda","fdsa");
        list.add(map);
        redisUtils.set("dffa",list,3);*/

        System.out.println(RedisPrefix.BAR.getPrefix());
        /*redisUtils.del(RedisPrefix.BAR.getPrefix());*/
        redisTemplate.delete(RedisPrefix.BAR.getPrefix());

    }

}
