package StudentInfoManage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteStudent {
	public void DelStu(String id){
		DBOper dbOper=new DBOper();
		Connection connection;
		PreparedStatement pstm=null;
		try {
		connection = dbOper.getConnection();//���ݿ�����
		String sql="delete from info where id=?";
		pstm=connection.prepareStatement(sql);//ʵ����prepareStatement
		//����?������
		pstm.setString(1, id);
		pstm.executeUpdate();//�������ݿ�
		//�رղ���
		pstm.close();
		connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
