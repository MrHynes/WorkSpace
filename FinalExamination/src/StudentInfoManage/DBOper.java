package StudentInfoManage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBOper {
	//����mysql�����ݿ���������
	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	//����mysql���ݿ�����ӵ�ַ
	public static final String DBURL="jdbc:mysql://localhost:3306/stuinfo";
	//���ݿ��������
	public static final String DBUSER="root";
	//���ݿ����������
	public static final String DBPASS="chengqi";
	public Connection getConnection() throws Exception{	
			Class.forName(DBDRIVER);
			Connection connection=DriverManager.getConnection(DBURL,DBUSER,DBPASS);//�������ݿ�
			return connection;
	}
}
