package Chapter19_Echo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
//��ͬһ��ʱ���ڣ�ֻ����һ���ͻ��˷��ʷ����������Ҫʵ�ֶ���ͻ���ͬʱ���ʷ�������Ҫ�ڷ�����ʹ�ö��߳�
public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server=null;
		server=new ServerSocket(8888);
		Socket client=null;
		boolean flag=true;
		BufferedReader buf=null;
		PrintStream out=null;
		while(flag){
			System.out.println("���������У��ȴ��ͻ�������");
			client=server.accept();//���տͻ�������
			System.out.println("���ӳɹ�");
			buf=new BufferedReader(new InputStreamReader(client.getInputStream()));//�õ��ͻ��˵�������Ϣ
			out=new PrintStream(client.getOutputStream());//ʵ�����ͻ��������
			boolean f=true;
			while(f){
				String str=buf.readLine();
				if(str==null||"".equals(str)){
					f=false;
				}else{
					if("bye".equals(str)){
						f=false;
					}else{
						out.println("Echo:"+str);//��ͻ��������Ϣ
						System.out.println(str);
					}		
				}
			}
			out.close();
			client.close();
		}
		server.close();
	}
}
