package Chapter12_RandomAccessFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;


public class RAFDemo {
	public static void main(String[] args) throws Exception {
		String path="F:" + File.separator + "WorkSpace" + File.separator + "JavaProject" + File.separator + "src"
				+ File.separator + "Chapter12_RandomAccessFile"+File.separator+"f.txt";
		File f=new File(path);
		RandomAccessFile file=new RandomAccessFile(f, "rw");
		//Ð´Êý¾Ý
		String name=null;
		int age=0;
		name="aaaaaaaa";
		age=18;
		file.writeBytes(name);
		file.writeInt(age);
		name="bbbbbbbb";
		age=19;
		file.writeBytes(name);
		file.writeInt(age);
		name="cccccccc";
		age=20;
		file.writeBytes(name);
		file.writeInt(age);
		System.out.println("success");
		file.close();
	}
}
