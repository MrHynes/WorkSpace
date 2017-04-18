package pers.qiqcheng.spring.demo05;

public class Car {
	private String name;
	private float price;
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + "]";
	}

}
