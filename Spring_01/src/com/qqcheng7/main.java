package com.qqcheng7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qqcheng.demo;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans_for_cheng7.xml");
		demo xDemo=(demo)context.getBean("demo");
		xDemo.hello();
		demo xDemo2=(demo)context.getBean("demo");
		xDemo2.hello();

	}

}
