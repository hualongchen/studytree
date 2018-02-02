package com.tongrong.order.util.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by chenhualong on 2016/12/3.
 */

@Component
public class RedisUtil {


    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * 塞值包含失效时间自己确定  KEY-VALUE形式
     *
     * @param form
     */
    public void setValue(RedisForm form) {

        //向redis里存入数据和设置缓存时间
        redisTemplate.opsForValue().set(form.getKey().toString(), form.getValue().toString(),form.getDueTime(),TimeUnit.SECONDS);

    }




    /**
     * 获取对应的缓存值
     *
     * @param form
     * @return
     */
    public RedisForm getValue(RedisForm form) {

        RedisForm returnForm = new RedisForm();

        returnForm.setKey(form.getKey());

        Object  object =redisTemplate.opsForValue().get(form.getKey());

        if(null != object){

            returnForm.setValue(object);
        }

        return returnForm;
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }


    /**
     * 删除对应的value
     *
     * @param key key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }


}
