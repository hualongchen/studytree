package com.tongrong.order.util.redis;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by chenhualong on 2016/12/3.
 */

@SuppressWarnings("serial")
@Data
public class RedisForm implements Serializable {


    private Object key ;

    private Object value ;

    //过期失效时长
    private long dueTime ;


}
