package Chapter19_Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class CInetAddress {
	public static void main(String[] args) throws Exception {
		InetAddress locAdd=InetAddress.getLocalHost();
		InetAddress remAdd=InetAddress.getByName("www.baidu.com");
		
		System.out.println("����ip��ַ"+locAdd.getHostAddress());
		System.out.println("Զ��ip��ַ"+remAdd.getHostAddress());
		System.out.println("�����Ƿ�ɴ�"+locAdd.isReachable(5000));
		System.out.println("Զ���Ƿ�ɴ�"+remAdd.isReachable(5000));
	}

}
