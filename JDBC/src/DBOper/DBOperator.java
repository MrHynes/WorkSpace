package DBOper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperator {
	//����mysql�����ݿ���������
	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	//����mysql���ݿ�����ӵ�ַ
	public static final String DBURL="jdbc:mysql://localhost:3306/test";
	//���ݿ��������
	public static final String DBUSER="root";
	//���ݿ����������
	public static final String DBPASS="chengqi";
	public static void main(String[] args) throws Exception {
		//������������
		Class.forName(DBDRIVER);
		Connection conn=null;
		Statement stmt=null;
		String id="1004";
		String name="kankang";
		int age=20;
		//�����¼
		//String sql="insert into userinfo(id,name,age) values('"+id+"','"+name+"',"+age+")";
		//�޸ļ�¼
		//String sql="update userinfo set id='1005',name='kk',age=19 where id='1004'";
		//ɾ����¼
		String sql="delete from userinfo where id='1005'";
		//�������ݿ�
		conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		stmt=conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
	}
}







