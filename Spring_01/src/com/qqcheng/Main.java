package com.qqcheng;

import javax.swing.DefaultDesktopManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * ����demo�Ķ���
		 * demo helloWorld=new demo();
		 * Ϊname��ֵ
		 * helloWorld.setname("chengqi");
		*/
		/**
		 * Spring 
		 */
		//1.����Spring������IOC����
		ApplicationContext ct=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.��IOC������ȡBeanʵ��
		demo demoHello=(demo)ct.getBean("helloWorld");
		//3.����hello����
		demoHello.hello();
	}

}
