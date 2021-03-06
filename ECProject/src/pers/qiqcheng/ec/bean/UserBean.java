package pers.qiqcheng.ec.bean;

import java.util.Date;

public class UserBean {
	private Integer ID;
	private String userName;
	private String passWord;
	private String sex;
	private String relName;
	private Date birthDay;
	private String telePhone;
	private String email;
	private String postCode;
	private String address;
	private Integer status;
	private Date joniDate;
	private Date loginTime;
	private Integer loginNum;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRelName() {
		return relName;
	}
	public void setRelName(String relName) {
		this.relName = relName;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getJoniDate() {
		return joniDate;
	}
	public void setJoniDate(Date joniDate) {
		this.joniDate = joniDate;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Integer getLoginNum() {
		return loginNum;
	}
	public void setLoginNum(Integer loginNum) {
		this.loginNum = loginNum;
	}
	@Override
	public String toString() {
		return "UserBean [userName=" + userName + ", passWord=" + passWord + ", sex=" + sex + ", relName=" + relName
				+ ", birthDay=" + birthDay + ", telePhone=" + telePhone + ", email=" + email + ", postCode=" + postCode
				+ ", address=" + address + "]";
	}
	

}
