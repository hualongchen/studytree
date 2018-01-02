package user.modul;

import lombok.Data;

import java.io.Serializable;

/**
 * @author :chenhualong
 * @Date : created in 15:20 2017/12/27
 */

@Data
public class UserInfoServiceDTO  implements Serializable{


    /**
     * 手机号
     */
    private  String mobilePhone ;

    /**
     * 用户ID
     */
    private  int  userId ;


    /**
     * 用户名
     */
    private String userName ;


    /**
     * 用户年纪
     */
    private int age ;


}
