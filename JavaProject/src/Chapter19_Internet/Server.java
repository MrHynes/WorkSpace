package Chapter19_Internet;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server=new ServerSocket(8888);
		Socket client=null;
		System.err.println("服务器运行，等待客户端连接");
		client=server.accept();//等待客户端连接
		String string="hello client";
		PrintStream out=new PrintStream(client.getOutputStream());
		out.print(string);
		out.close();
		client.close();
		server.close();
	}

}
