package pers.qiqcheng.spring.demo10;



public class CustomDaoImpl implements CustomDao {

	@Override
	public void add() {
		System.out.println("ADD...");
	}

	@Override
	public void update() {
		System.out.println("UPDATE..");
	}

}
