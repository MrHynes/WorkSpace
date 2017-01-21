package StudentInfoManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShowStudent {
	public void ShowAllStu(){
		DBOper dbOper=new DBOper();
		Connection connection;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
		connection = dbOper.getConnection();//连接数据库
		String sql="select * from info";
		pstm=connection.prepareStatement(sql);//实例化对象
		rs=pstm.executeQuery();//实例化ResultSet对象
		while(rs.next()){//指针向下移动
			String stuID;
			String stuName;
			int stuAge;
			float stuScore;
			//获取学生信息
			stuID=rs.getString(1);
			stuName=rs.getString(2);
			stuAge=rs.getInt(3);
			stuScore=rs.getFloat(4);
			//在控制台输出所有信息
			System.out.println("ID:"+stuID+",Name:"+stuName+",Age:"+stuAge+",Score:"+stuScore);
		}
		//关闭操作
		pstm.close();
		connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
