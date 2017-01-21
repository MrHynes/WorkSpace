package com.qqcheng;
public class demo {
	private  String name;
	public void setName(String name){
		System.out.println("setName:"+name);
		this.name=name;
	}
	public void hello(){
		System.out.println("hello "+name);
	}
	public demo() {
		System.out.println("Constructed function");
	}
}
