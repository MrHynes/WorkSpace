package Chapter19_Echo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
//在同一个时间内，只能有一个客户端访问服务器，如果要实现多个客户端同时访问服务器则要在服务器使用多线程
public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server=null;
		server=new ServerSocket(8888);
		Socket client=null;
		boolean flag=true;
		BufferedReader buf=null;
		PrintStream out=null;
		while(flag){
			System.out.println("服务器运行，等待客户端连接");
			client=server.accept();//接收客户端连接
			System.out.println("连接成功");
			buf=new BufferedReader(new InputStreamReader(client.getInputStream()));//得到客户端的输入信息
			out=new PrintStream(client.getOutputStream());//实例化客户端输出流
			boolean f=true;
			while(f){
				String str=buf.readLine();
				if(str==null||"".equals(str)){
					f=false;
				}else{
					if("bye".equals(str)){
						f=false;
					}else{
						out.println("Echo:"+str);//向客户端输出信息
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
