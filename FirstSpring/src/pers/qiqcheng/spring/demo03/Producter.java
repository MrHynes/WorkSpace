package pers.qiqcheng.spring.demo03;

public class Producter {
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	public void init(){
		System.out.println("��ʼ������..");
	}
	public void destroy(){
		System.out.println("���ٷ���..");
	}
	@Override
	public String toString() {
		return "Producter [name=" + name + "]";
	}
	public void sayHello(){
		System.out.println("hello!");
	}

}
