package StudentInfoManage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteStudent {
	public void DelStu(String id){
		DBOper dbOper=new DBOper();
		Connection connection;
		PreparedStatement pstm=null;
		try {
		connection = dbOper.getConnection();//数据库连接
		String sql="delete from info where id=?";
		pstm=connection.prepareStatement(sql);//实例化prepareStatement
		//设置?的内容
		pstm.setString(1, id);
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
