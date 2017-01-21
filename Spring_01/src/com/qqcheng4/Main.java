package com.qqcheng4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans_for_cheng4.xml");
		//
		Car car=(Car)context.getBean("car");
		System.out.println(car.toString());
		//使用list结点为List类型的属性赋值 
		Person person=(Person)context.getBean("person");
		System.out.println(person.toString());
		//使用Map节点以及Map的entry子节点配置Map类型的成员变量
		newPerson newperson=(newPerson)context.getBean("newPerson");
		System.out.println(newperson.toString());
		//使用props和prop子节点为properties 属性赋值
		dataSource datasource =(dataSource)context.getBean("dataSource");
		System.out.println(datasource.toString());
		//配置独立的集合bean，以供多个bean进行引用 
		Person person2=(Person)context.getBean("person2");
		System.out.println(person2.toString());
		//通过p命名空间为bean属性赋值
		Person person3=(Person)context.getBean("person3");
		System.out.println(person3.toString());
	}

}
