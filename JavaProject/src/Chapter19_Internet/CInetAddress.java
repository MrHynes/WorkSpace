package Chapter19_Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class CInetAddress {
	public static void main(String[] args) throws Exception {
		InetAddress locAdd=InetAddress.getLocalHost();
		InetAddress remAdd=InetAddress.getByName("www.baidu.com");
		
		System.out.println("本地ip地址"+locAdd.getHostAddress());
		System.out.println("远程ip地址"+remAdd.getHostAddress());
		System.out.println("本机是否可达"+locAdd.isReachable(5000));
		System.out.println("远程是否可达"+remAdd.isReachable(5000));
	}

}
