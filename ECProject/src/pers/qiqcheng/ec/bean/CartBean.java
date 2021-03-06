package pers.qiqcheng.ec.bean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class CartBean {
	private List<CartItemBean> items;
	private Integer count;//商品数量之和
	private Float totalPrice;//所有商品价格之和
	private CartBean(){
		items = new ArrayList<CartItemBean>();
		count = 0;
		totalPrice = 0.0f;
	}
	public static CartBean getCartBean(HttpSession session){
		CartBean cartBean=(CartBean)session.getAttribute("cartBean");
		if(cartBean==null){
			cartBean=new CartBean();
			session.setAttribute("cartBean", cartBean);
		}
		return cartBean;	
	}
	public static CartBean getCartOrderBean(HttpSession session){
		CartBean cartOrderBean=(CartBean)session.getAttribute("cartOrderBean");
		if(cartOrderBean==null){
			cartOrderBean=new CartBean();
			session.setAttribute("cartOrderBean",cartOrderBean);
		}
		return cartOrderBean;	
	}
	public CartItemBean isItemExits(String goodID){
		for (CartItemBean cartItemBean : items) {
			if(cartItemBean.getGoodID().equals(goodID)){
				return cartItemBean;
			}
		}
		return null;
	}
	public List<CartItemBean> getItems() {
		return items;
	}
	public void setItems(List<CartItemBean> items) {
		this.items = items;
	}
	public Integer getCount() {
		this.count=0;
		for (CartItemBean cartItemBean : items) {
			this.count+=cartItemBean.getCount();
		}
		return count;
	}
	
	public Float getTotalPrice() {
		this.totalPrice=0.0f;
		for (CartItemBean cartItemBean : items) {
			this.totalPrice+=cartItemBean.getTotalPrice();
		}
		return totalPrice;
	}
	
	

}
