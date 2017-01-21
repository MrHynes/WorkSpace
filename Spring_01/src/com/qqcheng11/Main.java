package com.qqcheng11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans_for_cheng11.xml");
		Car car=(Car)context.getBean("car1");
		System.out.println(car);

	}
}
