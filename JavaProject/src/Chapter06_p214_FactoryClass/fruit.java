package Chapter06_p214_FactoryClass;

public interface fruit {
	void eat();
}
class Apple implements fruit{

	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("eat apple");
	}
	
}
class Orange implements fruit{

	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("eat orange");
	}
}

//定义工厂类
class Factory{
	public fruit getInstance(String fruitName){
		fruit f = null;
		if(("apple").equals(fruitName)){
			f=new Apple();
		}
		if(("orange").equals(fruitName)){
			f=new Orange();
		}
		return f;	
	}
}