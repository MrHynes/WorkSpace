package com.qqcheng13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qqcheng13.controller.UserController;
import com.qqcheng13.respository.UserRespository;
import com.qqcheng13.service.UserService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans_for_cheng13.xml");
//		TestObject object=(TestObject)context.getBean("testObject");
//		System.out.println(object);
		UserController userController=(UserController)context.getBean("userController");
		System.out.println(userController);
		userController.execute();
//		UserService userService=(UserService)context.getBean("userService");
//		System.out.println(userService);
//		UserRespository userRespository=(UserRespository)context.getBean("userRespository");
//		System.out.println(userRespository);
		

	}

}
