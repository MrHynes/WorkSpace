package com.qqcheng10;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("Beans_for_cheng10.xml");
		Car car=(Car)context.getBean("car");
		System.out.println(car);
		//¹Ø±ÕIOC
		context.close();

	}

}
