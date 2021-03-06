package pers.qiqcheng.ec.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartItemBean {
	//private String userName;
	private String goodID;
	private String goodName;
	private Float  goodPrice;
	private int count;
	private float totalPrice;
	
	public CartItemBean(){
		this.count=0;
		this.totalPrice=0.0f;
	}
	public void setCount(int count) {
		this.count = count;
		this.totalPrice=this.goodPrice*count;
	}
	public CartItemBean setCartItemBean(ResultSet rs) throws SQLException{
		while(rs.next()){
		this.goodID=rs.getString(1);
		this.goodName=rs.getString(4);
		this.goodPrice=rs.getFloat(5);
		}
		return this;
	}
	/*public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}*/
	public String getGoodID() {
		return goodID;
	}
	public void setGoodID(String goodID) {
		this.goodID = goodID;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public Float getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(Float goodPrice) {
		this.goodPrice = goodPrice;
	}
	public int getCount() {
		return count;
	}
	
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	

}
