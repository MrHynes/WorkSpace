package com.ch07.MVC;

public class User {
	private String userName;
	private String userPassword;
	private String userSex;
	private String userProvince;
	private String userIntroduce;
	public User(){
		
	}
	
	public User(String userName, String userPassword, String userSex, String userProvince, String userIntroduce) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.userProvince = userProvince;
		this.userIntroduce = userIntroduce;
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
	public String getuserSex() {
		return userSex;
	}
	public void setuserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserProvince() {
		return userProvince;
	}
	public void setUserProvince(String userProvince) {
		this.userProvince = userProvince;
	}
	public String getUserIntroduce() {
		return userIntroduce;
	}
	public void setUserIntroduce(String userIntroduce) {
		this.userIntroduce = userIntroduce;
	}
	

}
