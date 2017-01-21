package com.qqcheng6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qqcheng5.Address;
import com.qqcheng5.Person;

public class Main {
	public static void main(String[] args) {
	ApplicationContext context =new ClassPathXmlApplicationContext("Beans_for_cheng6.xml");
	Address address=(Address)context.getBean("Address2");
	System.out.println(address.toString());
	Person person=(Person)context.getBean("person");
	System.out.println(person.toString());		
	}

}
