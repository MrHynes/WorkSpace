package com.ch05.Listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {

	private String name;
	private String data;

	public User(String name) {
		this.name = name;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		this.data=this.name+"������HttpSession�����С�";
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		this.data=this.name+"���Ƴ�HttpSession�����С�";
	}

	public String getData() {
		return this.data;
	}
	
}
