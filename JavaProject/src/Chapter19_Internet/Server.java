package Chapter19_Internet;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server=new ServerSocket(8888);
		Socket client=null;
		System.err.println("���������У��ȴ��ͻ�������");
		client=server.accept();//�ȴ��ͻ�������
		String string="hello client";
		PrintStream out=new PrintStream(client.getOutputStream());
		out.print(string);
		out.close();
		client.close();
		server.close();
	}

}
