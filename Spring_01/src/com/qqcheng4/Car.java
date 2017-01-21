package com.qqcheng4;

public class Car {
	private String carOfName;
	private double carOfSPeed;
	public Car() {
		super();
	}
	
	public void setCarOfName(String carOfName) {
		this.carOfName = carOfName;
	}
	
	public void setCarOfSPeed(double carOfSPeed) {
		this.carOfSPeed = carOfSPeed;
	}
	@Override
	public String toString() {
		return "Car [carOfName=" + carOfName + ", carOfSPeed=" + carOfSPeed + "]";
	}

	public Car(String carOfName, double carOfSPeed) {
		super();
		this.carOfName = carOfName;
		this.carOfSPeed = carOfSPeed;
	}
	
}
