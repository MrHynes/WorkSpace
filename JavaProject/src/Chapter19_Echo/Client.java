package Chapter19_Echo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception{
		Socket client=new Socket("localhost", 8888);
		BufferedReader input=new BufferedReader(new InputStreamReader(client.getInputStream()));//接收客户端输出的信息
		PrintStream out=new PrintStream(client.getOutputStream());//向服务端输入信息
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));//从键盘输入信息
		boolean flag=true;
		while(flag){
			System.out.println("输入信息");
			String str=buf.readLine();
			out.println(str);
			if("bye".equals(str)){
				flag=false;
			}else{
				String echo=input.readLine();
				System.out.println(echo);
			}
		}
		client.close();
		input.close();
	}

}
