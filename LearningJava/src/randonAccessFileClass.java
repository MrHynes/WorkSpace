import java.io.*;
public class randonAccessFileClass {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file=new File("E:\\java.txt");
		if(file.exists()){
			file.delete();
			file.createNewFile();
		}
		RandomAccessFile refile=new RandomAccessFile(file,"rw");
		refile.writeBytes("I Love Java");//在文件中写入数据
		System.out.println(refile.getFilePointer());//	获取文件当前位置和开头的偏移量
		for(int i=0;i<refile.length();i++){
			refile.seek(i);//设置文件指针
			System.out.print((char)refile.readByte());//输出指针所在字节
		}
	}
}
