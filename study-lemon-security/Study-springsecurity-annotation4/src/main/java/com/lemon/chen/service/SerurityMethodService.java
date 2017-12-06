package com.lemon.chen.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

public interface SerurityMethodService {


    /**
     *
     * @Secured并没有起作用， 但是其他几个标签全部起作用了。
     */


    int findNum();

    @Secured("ROLE_ADMIN")
        //只能使用这个角色
    int update();

    @Secured({"ROLE_DBA", "ROLE_ADMIN"})
        //必须要两个角色权限
    int del();

    /**
     * 下面的采用EL表达式进行抉择
     * @return
     */
    //@PostAuthorize("returnObject.type == authentication.name")
    int one();

    @PreAuthorize("hasRole('ADMIN')")
    int two();

    @PreAuthorize("hasRole('ADMIN') AND hasRole('DBA')")
    int three();
}
