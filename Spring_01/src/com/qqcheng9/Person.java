package com.qqcheng9;

public class Person {
	private String name;
	private int age;
	//����address bean��city����
	private String city;
	//����car��price>=30w  Ϊ���� ����Ϊ����
	private String info;
	Car car;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", city=" + city + ", info=" + info + ", car=" + car + "]";
	}
	

}
