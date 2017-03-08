package com.dbop.vo;

public class Info {
	private String id;
	private String name;
	private int age;
	private float score;
	
	public Info() {
		super();
	}
	
	public Info(String id, String name, int age, float score) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
	
}
