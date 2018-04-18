package com.lemon.chen.lemonstudyactiviti.bean;

import java.io.Serializable;

/**
 * @author :chenhualong
 * @Date : created in 9:20 2018/4/18
 * @Description :
 */
public class Person implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 6757393795687480331L;

    private Integer id;//编号
    private String name;//姓名

    private String education;

    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
