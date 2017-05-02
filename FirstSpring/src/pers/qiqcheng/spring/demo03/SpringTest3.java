package pers.qiqcheng.spring.demo03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean�����÷�Χ
 * 
 * @author Buer
 *
 */
public class SpringTest3 {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Customer customer1 = (Customer) applicationContext.getBean("customer");
		System.out.println(customer1);
		Customer customer2 = (Customer) applicationContext.getBean("customer");
		System.out.println(customer2);
		// ���Է���customer1��customer2�ĵ�ַ��һ���ģ�˵��������ͬһ������ֻ��ʵ����һ�Σ���Ϊ<bean>��ǩ��scope����Ĭ��ֵΪsingleton
		//��scpoe���Ը�Ϊprototype
		//���г��򣬷���ʵ�������Σ�������������ͬ�Ķ���
	}
}