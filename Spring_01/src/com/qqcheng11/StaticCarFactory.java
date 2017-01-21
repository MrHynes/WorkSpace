package com.qqcheng11;

import java.applet.AudioClip;
import java.io.PushbackInputStream;
import java.util.HashMap;
import java.util.Map;

import com.qqcheng3.car;
import com.qqcheng4.newPerson;

/**
 * ��̬��������:֮�ʵ���ĳ����ľ�̬�����Ϳ��Է���bean��ʵ��
 * @author Buer
 *
 */
public class StaticCarFactory {
	private static Map<String, Car> cars=new HashMap<String,Car>();
	static{
		cars.put("Audi",new Car("Audi", 300000) );
		cars.put("Ford",new Car("Ford", 400000) );	
	}
	//��̬��������
	public static Car getCar(String name){
		return cars.get(name);
	}

}
