package pers.qiqcheng.ec.bean;

public class UserBean {
	private String user;
	private String pwd;
	private String name;
	private String sex;
	private String birth;
	private String email;
	private String phone;
	private String address;
	private String code;
	public UserBean() {
	}
	public UserBean(String user, String pwd, String name, String sex, String birth, String email, String phone,
			String address, String code) {
		super();
		this.user = user;
		this.pwd = pwd;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.code = code;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	

}
