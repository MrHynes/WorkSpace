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
		//�ж�һ��·���Ƿ���Ŀ¼
		System.out.println("·��path��Ŀ¼�� "+f.isDirectory());
		System.out.println("·��path2��Ŀ¼�� "+f2.isDirectory());
		//�����ļ���
		if(!f.exists()){
			f.mkdir();
		}
		//ʹ��list()���������ǰ·���µ������ļ�����
		String str[]=f2.list();
		for (String string : str) {
			System.out.println(string);
		}
		//ʹ��listFiles()���������ǰ·���µ������ļ�����
		System.out.println("************");
		File[] str2=f2.listFiles();
		for (File string : str2) {
			System.out.println(string);
		}
	}
}
