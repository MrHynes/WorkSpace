package pers.qiqcheng.spring.demo03;

public class Producter {
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	public void init(){
		System.out.println("初始化方法..");
	}
	public void destroy(){
		System.out.println("销毁方法..");
	}
	@Override
	public String toString() {
		return "Producter [name=" + name + "]";
	}
	public void sayHello(){
		System.out.println("hello!");
	}

}
