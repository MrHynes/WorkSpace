import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class CFileRW {
	public static void main(String[] args) throws Exception {
		String path = "F:" + File.separator + "WorkSpace" + File.separator + "Exp08" + File.separator + "src"
				+ File.separator + "f3.txt";
		File file = new File(path);
		Writer w=new FileWriter(file);
		w.write("hello³Ìì÷");
		w.write("\r\nhellojava");
		w.close();
		
		Reader r=new FileReader(file);
		int temp=0,len=0;
		char c[]=new char[1024];
		while((temp=r.read())!=-1){
			c[len]=(char)temp;
			len++;
		}
		r.close();
		System.out.println(new String(c));
	}

}
