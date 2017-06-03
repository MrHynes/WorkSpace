package pers.qiqcheng.ec.bean.admin;

public class AdminBean {
	private String userName;
	private String relName;
	private String sex;
	private String birthDay;
	private String email;
	private String telePhone;
	private String address;
	private String postCode;
	private String identify;
	private String registeTime;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRelName() {
		return relName;
	}
	public void setRelName(String relName) {
		this.relName = relName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getIdentify() {
		return identify;
	}
	public void setIdentify(String identify) {
		this.identify = identify;
	}
	public String getRegisteTime() {
		return registeTime;
	}
	public void setRegisteTime(String registeTime) {
		this.registeTime = registeTime;
	}
	@Override
	public String toString() {
		return "AdminBean [userName=" + userName + ", relName=" + relName + ", sex=" + sex + ", birthDay=" + birthDay
				+ ", email=" + email + ", telePhone=" + telePhone + ", address=" + address + ", postCode=" + postCode
				+ ", identify=" + identify + "]";
	}
	

}
