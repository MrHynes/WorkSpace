package laerningJava.chapter01;
import java.io.File;
public class testFileIterator {

	/**
	 * @param args
	 */
	static int j=0;
	public static void listFile(File f){
		//判断是否为空目录
		if(f!=null){
			//是否是目录
			if(f.isDirectory()){
				//如果是目录. 递归
				File files[]=f.listFiles();
				if(f!=null){
					for(int i=0;i<files.length;i++)
						listFile(files[i]);
				}
				//不是目录，直接输出文件名称
			}else{
				j++;
				System.out.println(f);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//遍历目录
		/*
		File file=new File("d:\\java");
		File files[]=file.listFiles();
		for(int i=0;i<files.length;i++){
			System.out.println(files[i]);
		}
		*/
		File file=new File("D://电影");
		listFile(file);
		//统计共有多少个文件 目录
		System.out.println(j);
	}
}
