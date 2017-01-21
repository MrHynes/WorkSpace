package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;

public class Client {
	public static void main(String[] args) throws Exception {
		Socket client=null;
		client=new Socket("localhost",8888);
		BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
		System.out.println(in.readLine());
		in.close();
		client.close();
	}

}
