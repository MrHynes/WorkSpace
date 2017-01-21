package com.qqcheng9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans_for_cheng9.xml");
		Address address=(Address)context.getBean("address");
		System.out.println(address.toString());
		
		Car car=(Car)context.getBean("car");
		System.out.println(car.toString());
		
		Person person=(Person)context.getBean("person");
		System.out.println(person.toString());

	}

}
