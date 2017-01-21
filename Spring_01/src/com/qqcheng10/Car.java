package com.qqcheng10;

public class Car {
	public Car() {
		// TODO Auto-generated constructor stub
		System.out.println("constructor...");
	}
	private String brand;
	
	public void setBrand(String brand) {
		System.out.println("setbrand...");
		this.brand = brand;
	}
	public void init(){
		System.out.println("inti...");
	}
	public void destroy(){
		System.out.println("destroy...");
	}

}
