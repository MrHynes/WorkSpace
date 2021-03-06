package pers.qiqcheng.spring.demo12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	public static void main(String[] args) {
		ApplicationContext ap=new ClassPathXmlApplicationContext("aopContext.xml");
		UserDao userDao=(UserDao)ap.getBean("userDao");
		userDao.add();
		userDao.update();
		userDao.delete();
		userDao.find();
		userDao.throwExp();
	}

}
