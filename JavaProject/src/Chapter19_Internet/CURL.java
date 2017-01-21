package Chapter19_Internet;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class CURL {

	public static void main(String[] args) throws Exception {
		URL url=new URL("http","www.baidu.com",80,"/search/error.html");
		InputStream in=url.openStream();
		Scanner scanner=new Scanner(in);
		scanner.useDelimiter("\n");
		while(scanner.hasNext()){
			System.out.println(scanner.next());
		}
	}
}
