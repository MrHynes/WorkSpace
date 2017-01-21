package StudentInfoManage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddStudent {
	public void AddStu(String id,String name,int age,float score){
		DBOper dbOper=new DBOper();
		Connection connection;
		PreparedStatement pstm=null;
		try {
		connection = dbOper.getConnection();//���ݿ�����
		String sql="insert into info values(?,?,?,?)";//sql��䣬����ѧ����Ϣ
		pstm=connection.prepareStatement(sql);
		//����SQL�����?������
		pstm.setString(1, id);
		pstm.setString(2, name);
		pstm.setInt(3, age);
		pstm.setFloat(4, score);
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
