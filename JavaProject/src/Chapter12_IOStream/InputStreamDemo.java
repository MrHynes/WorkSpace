package Chapter12_IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamDemo {
	public static void main(String[] args) throws Exception {
		File file = new File("F:" + File.separator + "WorkSpace" + File.separator + "JavaProject" + File.separator
				+ "src" + File.separator + "Chapter12_IOStream_ByteStream" + File.separator + "f.txt");
		InputStream in=new FileInputStream(file);
		
		/*ȫ������������
		byte b[]=new byte[(int)file.length()];//file.length(),���ļ��Ĵ�С
		in.read(b);
		in.close();
		System.out.println("�������ݵĳ���Ϊ"+file.length());
		System.out.println(new String(b));
		*/
		/*һ��һ���ֽڵĶ���������
		byte b2[]=new byte[(int)file.length()];
		for(int i=0;i<b2.length;i++){
			b2[i]=(byte)in.read();
		}
		in.close();
		System.out.println(new String(b2));	
		 */
		//�����Сδ֪ʱ����Ҫͨ���ж��Ƿ�����ļ���β�ķ�ʽ����ȡ�ļ�
		byte b[]=new byte[1024];
		int len=0;
		int temp=0;
		while((temp=in.read())!=-1){
			b[len]=(byte)temp;
			len++;
		}
		in.close();
		System.out.println("�ļ�����Ϊ��"+len+"\n����Ϊ��\n"+new String(b));
	}

}
