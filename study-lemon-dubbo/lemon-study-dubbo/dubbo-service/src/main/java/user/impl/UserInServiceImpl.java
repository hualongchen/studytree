package user.impl;


import user.api.UserInfoService;
import user.biz.UserBIZ;
import user.modul.UserInfoServiceDTO;
import user.modul.UserInfoServiceRequest;

import javax.annotation.Resource;

/**
 * @author :chenhualong
 * @Date : created in 16:24 2017/12/27
 */
public class UserInServiceImpl implements UserInfoService {


    @Resource
    private UserBIZ  userBIZ ;

    /**
     * 接口实现
     * @param id 用户ID
     * @return  用户信息
     */
    public UserInfoServiceDTO findUserByUserId(UserInfoServiceRequest request) {

        //TODO 判断基本属性

        return userBIZ.findUserInfo();
    }





    /**
     * 接口实现
     * @param mobilePhone  手机号码
     * @return 用户信息
     */
    public UserInfoServiceDTO findUserByMobilePhone(UserInfoServiceRequest request) {


        //TODO 判断基本属性
        return  userBIZ.findUserInfo();
    }
}
