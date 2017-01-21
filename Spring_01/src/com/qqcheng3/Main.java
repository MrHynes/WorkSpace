package com.qqcheng3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans_for_cheng3.xml");
		car Car=(car)context.getBean("car");
		System.out.println(Car.toString());
		person Person=(person)context.getBean("person");
		System.out.println(Person.toString());

	}
}
