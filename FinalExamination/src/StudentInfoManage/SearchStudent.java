package StudentInfoManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.jar.Attributes.Name;

public class SearchStudent {
	public void SearchStu(String name){
		DBOper dbOper=new DBOper();
		Connection connection;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
		connection = dbOper.getConnection();//连接数据库
		String sql="select * from info where name=? ";
		pstm=connection.prepareStatement(sql);//实例化prepareStatement
		pstm.setString(1, name);//设置?的内容
		rs=pstm.executeQuery();//实例化SesultSet对象
		while(rs.next()){
			String stuID;
			String stuName;
			int stuAge;
			float stuScore;
			//获取学生的信息
			stuID=rs.getString(1);
			stuName=rs.getString(2);
			stuAge=rs.getInt(3);
			stuScore=rs.getFloat(4);
			//在控制台输出所有的信息
			System.out.println("ID:"+stuID+",Name:"+stuName+",Age:"+stuAge+",Score:"+stuScore);
		}
		//操作关闭
		pstm.close();
		connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
