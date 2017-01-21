package com.qqcheng11;

import java.applet.AudioClip;
import java.io.PushbackInputStream;
import java.util.HashMap;
import java.util.Map;

import com.qqcheng3.car;
import com.qqcheng4.newPerson;

/**
 * 静态工厂方法:之际调用某个类的静态方法就可以返回bean的实例
 * @author Buer
 *
 */
public class StaticCarFactory {
	private static Map<String, Car> cars=new HashMap<String,Car>();
	static{
		cars.put("Audi",new Car("Audi", 300000) );
		cars.put("Ford",new Car("Ford", 400000) );	
	}
	//静态工厂方法
	public static Car getCar(String name){
		return cars.get(name);
	}

}
