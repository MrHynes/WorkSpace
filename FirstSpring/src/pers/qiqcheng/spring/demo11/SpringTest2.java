package pers.qiqcheng.spring.demo11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pers.qiqcheng.spring.demo10.CustomDao;
import pers.qiqcheng.spring.demo10.OrderDao;

/**
 * 安按照切面中定义的信息生成代理
 * @author Buer
 *
 */
public class SpringTest2 {
	public static void main(String[] args) {
		ApplicationContext ap =new ClassPathXmlApplicationContext("appContextWeb3.xml");
		OrderDao orderDao=(OrderDao)ap.getBean("orderDao1");
		CustomDao customDao=(CustomDao)ap.getBean("customDao1");
		orderDao.add();
		orderDao.delete();
		customDao.add();
		customDao.update();
	}
}
