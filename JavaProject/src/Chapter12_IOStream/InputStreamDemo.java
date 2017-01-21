package Chapter12_IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamDemo {
	public static void main(String[] args) throws Exception {
		File file = new File("F:" + File.separator + "WorkSpace" + File.separator + "JavaProject" + File.separator
				+ "src" + File.separator + "Chapter12_IOStream_ByteStream" + File.separator + "f.txt");
		InputStream in=new FileInputStream(file);
		
		/*全部读到数组中
		byte b[]=new byte[(int)file.length()];//file.length(),是文件的大小
		in.read(b);
		in.close();
		System.out.println("读入数据的长度为"+file.length());
		System.out.println(new String(b));
		*/
		/*一个一个字节的读到数组中
		byte b2[]=new byte[(int)file.length()];
		for(int i=0;i<b2.length;i++){
			b2[i]=(byte)in.read();
		}
		in.close();
		System.out.println(new String(b2));	
		 */
		//数组大小未知时，需要通过判断是否读到文件结尾的方式来读取文件
		byte b[]=new byte[1024];
		int len=0;
		int temp=0;
		while((temp=in.read())!=-1){
			b[len]=(byte)temp;
			len++;
		}
		in.close();
		System.out.println("文件长度为："+len+"\n内容为：\n"+new String(b));
	}

}
