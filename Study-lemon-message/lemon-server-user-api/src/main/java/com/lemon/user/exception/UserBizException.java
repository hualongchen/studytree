package com.lemon.user.exception;

import com.lemon.core.exception.BizException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author :chenhualong
 * @Date : created in 11:49 2018/1/31
 * @Description :
 */

@Slf4j
public class UserBizException extends BizException {





    public UserBizException(int code, String msgFormat) {
        super(code, msgFormat);
    }

    public UserBizException print() {

        log.info("==>BizException, code:" + this.code + ", msg:" + this.msg);
        return this;
    }
}
