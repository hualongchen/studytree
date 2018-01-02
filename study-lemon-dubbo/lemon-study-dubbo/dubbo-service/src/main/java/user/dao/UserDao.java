package user.dao;

import org.springframework.stereotype.Service;
import user.modul.UserInfoServiceDTO;

/**
 * @author :chenhualong
 * @Date : created in 15:07 2017/12/28
 * @Description :
 */

@Service
public class UserDao {




    /**
     * 相当于连接数据库进行操作
     * @return UserInfoServiceDTO
     */
    public UserInfoServiceDTO  findUserInfo(){

        UserInfoServiceDTO  userInfoServiceDTO = new UserInfoServiceDTO();

        userInfoServiceDTO.setAge(2);
        userInfoServiceDTO.setMobilePhone("18696728764");
        userInfoServiceDTO.setUserId(1);
        userInfoServiceDTO.setUserName("lemon");

        return userInfoServiceDTO;
    }


}
