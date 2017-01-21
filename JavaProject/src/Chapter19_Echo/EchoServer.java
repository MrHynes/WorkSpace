package Chapter19_Echo;

import java.net.ServerSocket;
import java.net.Socket;
//服务端使用了多线程，可以同时有多个客户端访问服务器
public class EchoServer {
	public static void main(String[] args) throws Exception {
		ServerSocket server=null;
		server=new ServerSocket(8888);
		Socket client=null;
		boolean flag=true;
		while(flag){
			System.out.println("服务器运行，等待客户端连接");
			client=server.accept();
			new Thread(new EchoThread(client)).start();
		}
		server.close();
	}

}
