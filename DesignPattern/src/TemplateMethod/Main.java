package TemplateMethod;

public class Main {
	public static void main(String[] args) {
		AbstractClass ac=null;
		ac=new COper1();
		ac.TemplateMethod();
		ac=new COper2();
		ac.TemplateMethod();
	}
}
