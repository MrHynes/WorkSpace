package com.qqcheng12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans_for_cheng12.xml");
		Car car=(Car)context.getBean("Car");
		System.out.println(car);
	}

}
