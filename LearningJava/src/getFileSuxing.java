import java.io.File;

public class getFileSuxing {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("E:\\test.txt");
		System.out.println("该文件的名字："+file.getName());
		System.out.println("该文件的绝对路径"+file.getAbsolutePath());
		System.out.println("该文件的父目录名字"+file.getParent());
		System.out.println("该文件的路径"+file.getPath());
		System.out.println("该文件的哈希码"+file.hashCode());
		System.out.println("该文件的长度（字节）"+file.length());
		System.out.println("改文件的最后一次修改时间"+file.lastModified());
	}
}