package com.lemon.bean;

import java.io.Serializable;

import lombok.Data;


@Data
public class UserDTO implements Serializable {

    /**
	 * 返回值
	 */
	private static final long serialVersionUID = 7248762979992208580L;
	

	private  String userName ;

    private String passWord ;

    private int id ;

    private int age ;

  
}
