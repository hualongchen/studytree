package user.api;


import user.exception.LemonException;
import user.modul.UserInfoServiceDTO;
import user.modul.UserInfoServiceRequest;

/**
 * @author :chenhualong
 * @Date : created in 15:12 2017/12/27
 * @Description :查询用户相关接口
 */
public interface UserInfoService {


    /**
     * @Description 通过用户ID查询信息
     */
    public UserInfoServiceDTO findUserByUserId(UserInfoServiceRequest request)throws LemonException;


    /**
     * @Description 通过注册手机查询用户信息
     */
    public UserInfoServiceDTO  findUserByMobilePhone(UserInfoServiceRequest request)throws LemonException;

}
