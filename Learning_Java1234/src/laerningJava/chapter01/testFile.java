package laerningJava.chapter01;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class testFile {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file=new File("d://创建的目录");
		if(file.mkdir()){
			System.out.println("文件夹创建成功！");
		}else{
			System.out.println("文件夹创建失败！");
		}
		file=new File("d://创建的目录//1.txt");
		if(file.createNewFile()){
			System.out.println("文件创建成功！");
		}
		else{
			System.out.println("文件创建失败！");
		}
		//删除1.txt
		if(file.delete()){
			System.out.println("文件删除成功！");
		}
		else{
			System.out.println("文件删除失败！");
		}
		//删除文件夹  “创建的目录”
		file=new File("d://创建的目录");
		if(file.delete()){
			System.out.println("文件夹删除成功！");
		}
		else{
			System.out.println("文件夹删除失败！");
		}
	}
}
