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
		this.data=this.name+"被绑定在HttpSession对象中。";
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		this.data=this.name+"被移出HttpSession对象中。";
	}

	public String getData() {
		return this.data;
	}
	
}
