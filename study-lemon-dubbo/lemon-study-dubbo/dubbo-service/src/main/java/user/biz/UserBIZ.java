package user.biz;

import org.springframework.stereotype.Service;
import user.dao.UserDao;
import user.modul.UserInfoServiceDTO;

import javax.annotation.Resource;

/**
 * @author :chenhualong
 */


@Service
public class UserBIZ {


    @Resource
    private UserDao userDao;



    public UserInfoServiceDTO findUserInfo(){

       return  userDao.findUserInfo();
    }


}
