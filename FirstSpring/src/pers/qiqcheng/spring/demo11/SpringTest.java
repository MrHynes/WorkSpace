package pers.qiqcheng.spring.demo11;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pers.qiqcheng.spring.demo10.CustomDao;
import pers.qiqcheng.spring.demo10.OrderDao;

/**
 * �Զ�����
 * @author Buer
 *
 */

public class SpringTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("appContextWeb2.xml");
		OrderDao orderDao=(OrderDao)applicationContext.getBean("orderDao");
		CustomDao customDao=(CustomDao)applicationContext.getBean("customDao");
		orderDao.add();
		orderDao.delete();;
		customDao.add();
		customDao.update();
	}
}
