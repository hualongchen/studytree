package com.lemon.order.exception;

import com.lemon.core.exception.BizException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author :chenhualong
 * @Date : created in 15:50 2018/1/30
 * @Description :
 */

@Slf4j
public class OrderBizException extends BizException {


    public OrderBizException(int code, String msgFormat) {

        super(code, msgFormat);
    }

    public OrderBizException print() {

        log.info("==>BizException, code:" + this.code + ", msg:" + this.msg);
        return this;
    }

}
