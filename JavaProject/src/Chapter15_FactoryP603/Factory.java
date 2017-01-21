package Chapter15_FactoryP603;
import java.lang.*;
public class Factory {
	public static Fruit getInstance(String className) throws Exception {
		Fruit fruit=null;
		fruit=(Fruit)Class.forName(className).newInstance();
		return fruit;
	}
}
