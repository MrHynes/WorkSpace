package com.qqcheng;

import javax.swing.DefaultDesktopManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 创建demo的对象
		 * demo helloWorld=new demo();
		 * 为name赋值
		 * helloWorld.setname("chengqi");
		*/
		/**
		 * Spring 
		 */
		//1.创建Spring容器的IOC对象
		ApplicationContext ct=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.从IOC容器获取Bean实例
		demo demoHello=(demo)ct.getBean("helloWorld");
		//3.调用hello方法
		demoHello.hello();
	}

}
