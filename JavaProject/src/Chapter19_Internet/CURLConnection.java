package Chapter19_Internet;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class CURLConnection {
	public static void main(String[] args) throws Exception {
		URL url=new URL("http://www.baidu.com");
		URLConnection urlCon=url.openConnection();
		System.out.println(urlCon.getContentLength());
		System.out.println(urlCon.getContentType());
		
		URL url2=new URL("http://cn.bing.com/");
		URLConnection urlConnection=url2.openConnection();
		System.out.println(urlConnection.getContentLength());
		System.out.println(urlConnection.getContentType());
	}

}
