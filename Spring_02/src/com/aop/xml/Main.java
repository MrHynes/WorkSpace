package com.aop.xml;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����spring��ioc����
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans-aop-xml.xml");
		//��IoC�����л�ȡbeanʵ��
		Calculate calculate=(Calculate)context.getBean("calculate");
		//ʹ��bean
		int resule=calculate.add(2, 3);
		System.out.println("result:"+resule);
		resule=calculate.sub(4,0);
		System.out.println("result:"+resule);
	}

}
