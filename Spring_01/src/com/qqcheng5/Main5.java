package com.qqcheng5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main5 {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans_for_cheng5.xml");
		Person person=(Person)context.getBean("person_ll");
		System.out.println(person.toString());
	}

}
