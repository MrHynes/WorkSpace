package pers.qiqcheng.springmvc.third;

public class StudentModel {
	private String name;
	private Integer age;
	public Integer getAge() {
		return age; 
	}
	public String getName() {
		return name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
}