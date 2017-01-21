package Chapter12_IOStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputStreamDemo1 {
	public static void main(String[] args) throws Exception {
		File file = new File("F:" + File.separator + "WorkSpace" + File.separator + "JavaProject" + File.separator
				+ "src" + File.separator + "Chapter12_IOStream_ByteStream" + File.separator + "f.txt");
		OutputStream out=new FileOutputStream(file);
		String str="helloworld1!\r\n";
		byte b[]=str.getBytes();
		out.write(b);
		//换行out.write("\r\n".getBytes());
		for (int i=0;i<b.length;i++){
			out.write(b[i]);
		}
		//追加内容,主要是调用FileOutputStream的构造方法进行实例化
		OutputStream out2=new FileOutputStream(file,true);
		String str2="helloworld2!\r\n";
		byte b2[]=str2.getBytes();
		out2.write(b2);
		for (int i=0;i<b2.length;i++){
			out2.write(b2[i]);
		}
		out.close();
	}

}
