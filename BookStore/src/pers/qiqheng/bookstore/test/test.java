package pers.qiqheng.bookstore.test;

import java.sql.ResultSet;

import pers.qiqcheng.bookstore.factory.DaoFactory;

public class test {
	public static void main(String[] args) {
		String sql="select * from userinfo where username=?";
		//String sql="insert into userinfo values(?,?)";
		//String sql="delete from userinfo where username=?";
		//String sql="update userinfo set password=? where username=?";
		String []params={"1234457"};
		try {
			ResultSet resultSet=DaoFactory.getBookDaoInstances().doSelect(sql, params);
			while(resultSet.next()){
				System.out.println(resultSet.getString(1)+ " "+resultSet.getString(2));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
