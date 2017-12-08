package com.lemon.bean;

import java.io.Serializable;

public class UserDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7248762979992208580L;
	

	private  String userName ;

    private String passWord ;

    private int id ;

    private int age ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
