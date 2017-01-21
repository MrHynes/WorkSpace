package com.qqcheng2;

public class HelloWorld {
	private String nameOfStu;
	private String schoolOfStu;
	private double incomeOfStu;
	private int ageOfStu;

	// 构造方法1
	public HelloWorld(String nameOfStu, String schoolOfStu, double incomeOfStu) {
		super();
		this.nameOfStu = nameOfStu;
		this.schoolOfStu = schoolOfStu;
		this.incomeOfStu = incomeOfStu;
	}

	// 构造方法2
	public HelloWorld(String name, String schoolOfStu, int ageOfStu) {
		super();
		this.nameOfStu = name;
		this.schoolOfStu = schoolOfStu;
		this.ageOfStu = ageOfStu;
	}

	public String getName() {
		return nameOfStu;
	}

	public void setName(String name) {
		this.nameOfStu = name;
	}

	public void show() {
		System.out.println("name: " + getName());
	}

	@Override
	public String toString() {
		return "HelloWorld [name=" + nameOfStu + ", schoolOfStu=" + schoolOfStu + ", incomeOfStu=" + incomeOfStu
				+ ", ageOfStu=" + ageOfStu + "]";
	}

}
