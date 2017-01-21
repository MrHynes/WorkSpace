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
		connection = dbOper.getConnection();//�������ݿ�
		String sql="select * from info where name=? ";
		pstm=connection.prepareStatement(sql);//ʵ����prepareStatement
		pstm.setString(1, name);//����?������
		rs=pstm.executeQuery();//ʵ����SesultSet����
		while(rs.next()){
			String stuID;
			String stuName;
			int stuAge;
			float stuScore;
			//��ȡѧ������Ϣ
			stuID=rs.getString(1);
			stuName=rs.getString(2);
			stuAge=rs.getInt(3);
			stuScore=rs.getFloat(4);
			//�ڿ���̨������е���Ϣ
			System.out.println("ID:"+stuID+",Name:"+stuName+",Age:"+stuAge+",Score:"+stuScore);
		}
		//�����ر�
		pstm.close();
		connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
