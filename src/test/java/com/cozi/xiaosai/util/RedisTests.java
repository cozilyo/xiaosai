package com.cozi.xiaosai.util;

import com.cozi.xiaosai.util.redis.RedisUtils;
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

    @Test
    public void test(){
       /* List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("sdf","fsdaf");
        map.put("fsda","fdsa");
        list.add(map);
        redisUtils.set("dffa",list,3);*/

       //redisUtils.set("fdsaf","fdsafdsjgoijweqij结防斯卡迪甲方开具收款富士达福建师大看见了看见就分手了打卡健康减肥连锁店看快捷方式打了卡jlkdsjafjsalk jlk");
        redisUtils.del("fdsaf");

    }

}
