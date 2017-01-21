package Chapter19_Echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class EchoThread implements Runnable{
	private Socket client=null;
	public EchoThread(Socket client){
		this.client=client;
	}
	public void run() {
		PrintStream out=null;
		BufferedReader buf=null;
		try {
			out=new PrintStream(client.getOutputStream());
			buf=new BufferedReader(new InputStreamReader(client.getInputStream()));
			boolean f=true;
			while(f){
				String str=buf.readLine();
				if(str==null||"".equals(str)){
					f=false;
				}else{
					if(str.equals("bye")){
						f=false;
					}else{
						out.println("ECHO:"+str);
						System.out.println(str);
					}
				}
			}
			out.close();
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
