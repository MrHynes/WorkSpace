package Chapter06_p214_FactoryClass;

public class mian {
	public static void main(String[] args) {
		//如果需要更换子类，那么就必须要更改main方法，那么要如何才能避免修改main方法呢？
		//答案就是工厂类Factory，fruit.java 定义工厂类
		/*
		fruit f=new Apple();
		f.eat();
		fruit o=new Orange();
		o.eat();
		*/
		fruit f=null;
		Factory factory=new Factory();
		f=factory.getInstance("apple");
		f.eat();
		f=factory.getInstance("orange");
		f.eat();
	}
}
