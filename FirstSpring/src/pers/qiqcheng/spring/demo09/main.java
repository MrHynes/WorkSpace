package pers.qiqcheng.spring.demo09;

public class main {
	public static void main(String[] args) {
		ProductDao productDao=new ProductDao();
		/*productDao.add();
		productDao.update();*/
		ProductDao proxy=new CGLibProxy(productDao).createProxy();
		proxy.add();
		proxy.update();
	}

}
