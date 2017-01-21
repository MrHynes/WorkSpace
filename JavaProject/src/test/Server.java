package test;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server=null;
		Socket client=null;
		PrintStream ps=null;
		server=new ServerSocket(8888);
		System.out.println("服务器开启，等待客户端连接");
		client=server.accept();
		String string="helloWorld";
		ps=new PrintStream(client.getOutputStream());
		ps.print(string);
		ps.close();
		client.close();
		server.close();
	}

}
