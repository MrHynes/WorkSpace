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
		connection = dbOper.getConnection();//�������ݿ�
		String sql="select * from info";
		pstm=connection.prepareStatement(sql);//ʵ��������
		rs=pstm.executeQuery();//ʵ����ResultSet����
		while(rs.next()){//ָ�������ƶ�
			String stuID;
			String stuName;
			int stuAge;
			float stuScore;
			//��ȡѧ����Ϣ
			stuID=rs.getString(1);
			stuName=rs.getString(2);
			stuAge=rs.getInt(3);
			stuScore=rs.getFloat(4);
			//�ڿ���̨���������Ϣ
			System.out.println("ID:"+stuID+",Name:"+stuName+",Age:"+stuAge+",Score:"+stuScore);
		}
		//�رղ���
		pstm.close();
		connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
