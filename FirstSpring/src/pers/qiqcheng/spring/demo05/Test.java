package pers.qiqcheng.spring.demo05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test{
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		//setter��ʽע������
		User user=(User)applicationContext.getBean("user");
		System.out.println(user.toString());
		//������ע������
		User user2=(User)applicationContext.getBean("user2");
		System.out.println(user2.toString());
		//p���ƿռ�ע������
		User user3=(User)applicationContext.getBean("user3");
		System.out.println(user3.toString());
		//SpEL����ע��
		User user4=(User)applicationContext.getBean("user4");
		System.out.println(user4.toString());
		//��������ע��
		CollectionBean collectionBean=(CollectionBean)applicationContext.getBean("collection");
		System.out.println(collectionBean.toString());
	}
}
