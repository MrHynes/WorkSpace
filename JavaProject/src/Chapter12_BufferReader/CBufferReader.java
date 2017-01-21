package Chapter12_BufferReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CBufferReader {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("输入内容：");
		String string=br.readLine();
		System.out.println("输入的内容是："+string);
	}

}
