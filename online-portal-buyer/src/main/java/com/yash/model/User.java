package com.yash.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.yash.utils.Constants;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull(message=Constants.PLEASE_PROVIDE_USER_ID)
	private Integer userId;
	
	@NotNull(message=Constants.PLEASE_PROVIDE_NAME)
	private String name;
	
	@NotNull(message=Constants.PLEASE_PROVIDE_USER_NAME)
	private String userName;
	
	@NotNull(message=Constants.PLEASE_PROVIDE_USER_PASSWORD)
	private String userPassword;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public User(Integer userId, String name, String userName, String userPassword) {
		super();
		this.userId = userId;
		this.name = name;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", userName=" + userName + ", userPassword=" + userPassword
				+ "]";
	}
	
	
	
}