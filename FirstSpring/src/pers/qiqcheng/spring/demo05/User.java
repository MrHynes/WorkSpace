package pers.qiqcheng.spring.demo05;

public class User {
	private String name;
	private float score;
	private Car car;
	public User() {
		System.out.println("创建对象..");
	}
	
	public User(String name, float score, Car car) {
		super();
		this.name = name;
		this.score = score;
		this.car = car;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setScore(float score) {
		this.score = score;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", score=" + score + ", car=" + car.toString() + "]";
	}
}
