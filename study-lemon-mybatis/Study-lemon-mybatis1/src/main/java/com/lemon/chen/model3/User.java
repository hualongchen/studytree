package com.lemon.chen.model3;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1878787040965647391L;
	private int id;
	private String username;
	private String mobile;
	private List<Post> posts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", mobile=" + mobile + ", posts=" + posts + "]";
	}

	

}