package com.lemon.api;

import com.lemon.bean.UserDTO;

/**
 * 暴露给外部的API
 */
public interface UserManagerAPI {


    /**
     * 通过ID查询用户
     * @param id
     * @return
     */
    public UserDTO  findUserById(int id) ;


    /**
     * 通过名称查询用户
     * @param userName
     * @return
     */
    public UserDTO  findUserByName(String userName) ;
}
