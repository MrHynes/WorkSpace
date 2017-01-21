package spring.listProperties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans-listProperties.xml");
		Car car=(Car)context.getBean("car");
		System.out.println(car);
		person per=(person)context.getBean("person");
		System.out.println(per);
		person_map per_map=(person_map)context.getBean("person_map");
		System.out.println(per_map);
		person_properties properties=(person_properties)context.getBean("person_properties");
		System.out.println(properties);
		person per0=(person)context.getBean("person2");
		System.out.println(per0);
		
		Car car2=(Car)context.getBean("car3");
		System.out.println(car2);
	}
}
