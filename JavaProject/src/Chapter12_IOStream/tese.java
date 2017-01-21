package Chapter12_IOStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
public class tese {
	public static void main(String[] args) throws Exception {
		File file = new File("F:" + File.separator + "WorkSpace" + File.separator + "JavaProject" + File.separator
				+ "src" + File.separator + "Chapter12_IOStream_ByteStream" + File.separator + "f.txt");
		InputStream in=new FileInputStream(file);
		byte b[]=new byte[1024];
		int temp;
		int len=0;
		while((temp=in.read())!=-1){
			b[len]=(byte)temp;
			len++;
		}
		in.close();
		System.out.println(new String(b,0,len));
	}

}
