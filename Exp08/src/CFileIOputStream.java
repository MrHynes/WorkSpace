import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CFileIOputStream {
	public static void main(String[] args) throws Exception {
		String path = "F:" + File.separator + "WorkSpace" + File.separator + "Exp08" + File.separator + "src"
				+ File.separator + "f2.txt";
		File file = new File(path);
		OutputStream out=new FileOutputStream(file);
		String string="hello ³Ìì÷";
		byte b[]=string.getBytes();
		out.write(b);
		
		byte c[]=new byte[b.length];
		InputStream in=new FileInputStream(file);
		in.read(c);
		System.out.println(new String(c));
	}
}
