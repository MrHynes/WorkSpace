package Chapter19_Echo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception{
		Socket client=new Socket("localhost", 8888);
		BufferedReader input=new BufferedReader(new InputStreamReader(client.getInputStream()));//���տͻ����������Ϣ
		PrintStream out=new PrintStream(client.getOutputStream());//������������Ϣ
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));//�Ӽ���������Ϣ
		boolean flag=true;
		while(flag){
			System.out.println("������Ϣ");
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
