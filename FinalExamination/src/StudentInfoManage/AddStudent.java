package StudentInfoManage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddStudent {
	public void AddStu(String id,String name,int age,float score){
		DBOper dbOper=new DBOper();
		Connection connection;
		PreparedStatement pstm=null;
		try {
		connection = dbOper.getConnection();//数据库连接
		String sql="insert into info values(?,?,?,?)";//sql语句，插入学生信息
		pstm=connection.prepareStatement(sql);
		//设置SQL语句中?的内容
		pstm.setString(1, id);
		pstm.setString(2, name);
		pstm.setInt(3, age);
		pstm.setFloat(4, score);
		pstm.executeUpdate();//更新数据库
		//关闭操作
		pstm.close();
		connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
