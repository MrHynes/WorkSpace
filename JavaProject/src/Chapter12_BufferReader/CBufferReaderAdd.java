package Chapter12_BufferReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CBufferReaderAdd {

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("输入一个数字:");
		String num1=bufferedReader.readLine();
		System.out.println("输入一个数字:");
		String num2=bufferedReader.readLine();
		int numi=Integer.parseInt(num1);
		int numj=Integer.parseInt(num2);
		System.out.println(numi+"+"+numj+"="+(numi+numj));
	}
}
