package pers.qiqcheng.bookstore.bean;

public class UserBean {
	private String userName;//�û���
	private String passWord;//����
	private String relName;
	private String telNumber;
	private String postalCode;
	private String address;
	
	public UserBean() {
		super();
	}
	
	public UserBean(String userName, String passWord, String relName, String telNumber, String postalCode,
			String address) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.relName = relName;
		this.telNumber = telNumber;
		this.postalCode = postalCode;
		this.address = address;
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
	public String getRelName() {
		return relName;
	}
	public void setRelName(String relName) {
		this.relName = relName;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
