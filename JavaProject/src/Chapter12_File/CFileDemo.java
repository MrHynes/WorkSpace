package Chapter12_File;

import java.io.File;

public class CFileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "F:" + File.separator + "WorkSpace" + File.separator + "JavaProject" + File.separator + "src"
				+ File.separator + "Chapter12_File" + File.separator + "createNewFile";
		String path2 = "F:" + File.separator + "WorkSpace" + File.separator + "JavaProject" + File.separator + "src"
				+ File.separator + "Chapter12_File";
		File f=new File(path);
		File f2=new File(path2);
		//判断一个路径是否是目录
		System.out.println("路径path是目录吗？ "+f.isDirectory());
		System.out.println("路径path2是目录吗？ "+f2.isDirectory());
		//创建文件夹
		if(!f.exists()){
			f.mkdir();
		}
		//使用list()方法输出当前路径下的所有文件名称
		String str[]=f2.list();
		for (String string : str) {
			System.out.println(string);
		}
		//使用listFiles()方法输出当前路径下的所有文件名称
		System.out.println("************");
		File[] str2=f2.listFiles();
		for (File string : str2) {
			System.out.println(string);
		}
	}
}
