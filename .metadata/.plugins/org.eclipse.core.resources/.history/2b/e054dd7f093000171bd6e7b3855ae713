package pers.qiqcheng.spring.demo08;

public class main {
	public static void main(String[] args) {
		UserDao userDao=new UserDaoImpl();
		/*userDao.add();
		userDao.update();*/
		UserDao proxy=new JDKProxy(userDao).createProxy();
		proxy.add();
		proxy.update();
	}

}
