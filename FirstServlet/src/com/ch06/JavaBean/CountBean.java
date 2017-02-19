package com.ch06.JavaBean;

public class CountBean {
	private int count=0;
	public CountBean(){
	}
	public int getCount() {
		count++;
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
