package com.lemon.service;

import com.lemon.api.UserManagerAPI;
import com.lemon.bean.UserDTO;

public class UserviceImpl implements UserManagerAPI {


    /**
     * 这里也可以调用数据库进行实现
     *
     * @param id
     * @return
     */
    public UserDTO findUserById(int id) {

        UserDTO userDTO = new UserDTO();

        userDTO.setAge(11);
        userDTO.setPassWord("test");
        userDTO.setId(id);
        userDTO.setUserName("lemon");
        return userDTO;
    }

    public UserDTO findUserByName(String userName) {


        UserDTO userDTO = new UserDTO();

        userDTO.setAge(1111);
        userDTO.setPassWord("test222");
        userDTO.setId(3);
        userDTO.setUserName(userName);
        return userDTO;

    }
}
