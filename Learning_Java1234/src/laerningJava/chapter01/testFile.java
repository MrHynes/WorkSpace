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
		File file=new File("d://������Ŀ¼");
		if(file.mkdir()){
			System.out.println("�ļ��д����ɹ���");
		}else{
			System.out.println("�ļ��д���ʧ�ܣ�");
		}
		file=new File("d://������Ŀ¼//1.txt");
		if(file.createNewFile()){
			System.out.println("�ļ������ɹ���");
		}
		else{
			System.out.println("�ļ�����ʧ�ܣ�");
		}
		//ɾ��1.txt
		if(file.delete()){
			System.out.println("�ļ�ɾ���ɹ���");
		}
		else{
			System.out.println("�ļ�ɾ��ʧ�ܣ�");
		}
		//ɾ���ļ���  ��������Ŀ¼��
		file=new File("d://������Ŀ¼");
		if(file.delete()){
			System.out.println("�ļ���ɾ���ɹ���");
		}
		else{
			System.out.println("�ļ���ɾ��ʧ�ܣ�");
		}
	}
}
