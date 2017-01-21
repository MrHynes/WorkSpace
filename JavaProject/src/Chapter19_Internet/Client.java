package Chapter19_Internet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		Socket client=new Socket("localhost", 8888);
		BufferedReader buf=new BufferedReader(new InputStreamReader(client.getInputStream()));
		String string=buf.readLine();
		System.out.println("服务器输出内容:"+string);
		client.close();
		buf.close();
	}

}
