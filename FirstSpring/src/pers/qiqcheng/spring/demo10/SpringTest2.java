package pers.qiqcheng.spring.demo10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest2 {
	public static void main(String[] args) {
		ApplicationContext ap=new ClassPathXmlApplicationContext("appContextWeb.xml");
		OrderDao orderDao=(OrderDao)ap.getBean("proxy");//proxy ����
		orderDao.add();
		orderDao.update();
		orderDao.delete();
	}

}
