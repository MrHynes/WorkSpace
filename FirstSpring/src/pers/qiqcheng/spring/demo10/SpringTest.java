package pers.qiqcheng.spring.demo10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	/*@Autowired
	@Qualifier("customDaoProxy")
	static CustomDao customDao;*/
	public static void main(String[] args) {
		ApplicationContext ap=new ClassPathXmlApplicationContext("appContextWeb.xml");
		CustomDao customDao=(CustomDao)ap.getBean("customDaoProxy");
		customDao.add();
		customDao.update();
	}

}
