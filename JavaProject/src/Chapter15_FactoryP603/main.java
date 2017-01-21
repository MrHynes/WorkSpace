package Chapter15_FactoryP603;

import java.util.Properties;

public class main {
	public static void main(String[] args) throws Exception {
		Properties pro=Init.getPro();
		Fruit fruit = null;
		try {
			//fruit = Factory.getInstance("Chapter15_FactoryP603.Apple");
			//fruit=Factory.getInstance(pro.getProperty("Apple"));
			fruit=Factory.getInstance(pro.getProperty("Orange"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fruit.eat();
	}

}
