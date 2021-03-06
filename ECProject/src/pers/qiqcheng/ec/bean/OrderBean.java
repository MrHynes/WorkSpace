package pers.qiqcheng.ec.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderBean {
	private String orderID;
	private int typeCount;
	private int count;
	private  float totalPrice;
	private String orderDateTime;
	private List<OrderItemBean> items=null;
	public OrderBean(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		this.orderID=sdf.format(date);
		this.typeCount=0;
		this.count=0;
		this.totalPrice=0.0f;
		this.orderDateTime=sdf2.format(date);
	}
	//订单编号为时间+用户名
	public void setOrderID(String orderID) {
		this.orderID += orderID;
	}
	public String getOrderID() {
		return orderID;
	}

	public List<OrderItemBean> getItems() {
		return items;
	}
	public void setItems(List<OrderItemBean> items) {
		this.items = items;
	}
	public String  getOrderDateTime() {
		return orderDateTime;
	}
	public void setOrderDateTime(String  orderDate) {
		this.orderDateTime = orderDate;
	}
	public int getTypeCount() {
		return typeCount;
	}
	public void setTypeCount(int typeCount) {
		this.typeCount = typeCount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}
