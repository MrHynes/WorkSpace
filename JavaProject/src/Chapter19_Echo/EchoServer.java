package Chapter19_Echo;

import java.net.ServerSocket;
import java.net.Socket;
//�����ʹ���˶��̣߳�����ͬʱ�ж���ͻ��˷��ʷ�����
public class EchoServer {
	public static void main(String[] args) throws Exception {
		ServerSocket server=null;
		server=new ServerSocket(8888);
		Socket client=null;
		boolean flag=true;
		while(flag){
			System.out.println("���������У��ȴ��ͻ�������");
			client=server.accept();
			new Thread(new EchoThread(client)).start();
		}
		server.close();
	}

}
