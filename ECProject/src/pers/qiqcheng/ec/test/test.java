package pers.qiqcheng.ec.test;

import java.sql.ResultSet;

import pers.qiqcheng.ec.factory.DaoFactory;

public class test {
	public static void main(String[] args) {
		//String sql="insert into t_user values(?,?,?,?,?,?,?,?,?)";
		//String params[]={"qicheng","123456","chengqi","nan","19961205","10086@163.com","17805918389","funu","350108"};
		//String sql="select * from t_user";
		String sql="delete from t_user where suser=?";
		String params[]={"qicheng1"};
		boolean flag=false;
		try {
			//flag=DaoFactory.getUserDaoInstances().doInsert(sql, params);
			//ResultSet rs=DaoFactory.getUserDaoInstances().doSelect(sql, params);
			flag=DaoFactory.getUserDaoInstances().doDelete(sql, params);
			/*while(rs.next()){
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(5));
			}*/
			if(flag){
				System.out.println("ɾ���ɹ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}