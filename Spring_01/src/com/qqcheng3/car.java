package com.qqcheng3;

public class car {
	private String carOfName;
	private double carOfPrice;
	private double carOfSpeed;
	public car(String carOfName, double carOfPrice, double carOfSpeed) {
		super();
		this.carOfName = carOfName;
		this.carOfPrice = carOfPrice;
		this.carOfSpeed = carOfSpeed;
	}
	
	public car() {
		super();
	}

	@Override
	public String toString() {
		return "car [carOfName=" + carOfName + ", carOfPrice=" + carOfPrice + ", carOfSpeed=" + carOfSpeed + "]";
	}
	
	public void setCarOfSpeed(double carOfSpeed) {
		this.carOfSpeed = carOfSpeed;
	}
	
	public void setCarOfName(String carOfName) {
		this.carOfName = carOfName;
	}
	
	public void setCarOfPrice(double carOfPrice) {
		this.carOfPrice = carOfPrice;
	}
	
	
	

}
