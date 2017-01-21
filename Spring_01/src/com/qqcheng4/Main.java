package com.qqcheng4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans_for_cheng4.xml");
		//
		Car car=(Car)context.getBean("car");
		System.out.println(car.toString());
		//ʹ��list���ΪList���͵����Ը�ֵ 
		Person person=(Person)context.getBean("person");
		System.out.println(person.toString());
		//ʹ��Map�ڵ��Լ�Map��entry�ӽڵ�����Map���͵ĳ�Ա����
		newPerson newperson=(newPerson)context.getBean("newPerson");
		System.out.println(newperson.toString());
		//ʹ��props��prop�ӽڵ�Ϊproperties ���Ը�ֵ
		dataSource datasource =(dataSource)context.getBean("dataSource");
		System.out.println(datasource.toString());
		//���ö����ļ���bean���Թ����bean�������� 
		Person person2=(Person)context.getBean("person2");
		System.out.println(person2.toString());
		//ͨ��p�����ռ�Ϊbean���Ը�ֵ
		Person person3=(Person)context.getBean("person3");
		System.out.println(person3.toString());
	}

}
