package com.qqcheng2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans_for_cheng2.xml");
		HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
		System.out.println(helloWorld.toString());
	}
}
