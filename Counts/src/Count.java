import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Count {
	public static void main(String[] args) {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null; // ���ڰ�װInputStreamReader,��ߴ������ܡ���ΪBufferedReader�л���ģ���InputStreamReaderû�С�
		try {
			String str = "";
			String key="a";
			int index=0;
			int count=0;
			fis = new FileInputStream("F:" + File.separator + "WorkSpace" + File.separator + "Counts" + File.separator
					+ "src" + File.separator + "file.txt");// FileInputStream
			// ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
			isr = new InputStreamReader(fis);// InputStreamReader ���ֽ���ͨ���ַ���������,
			br = new BufferedReader(isr);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new
											// InputStreamReader�Ķ���
			//ÿ��ѭ����ȡ�ļ�һ������
			while ((str = br.readLine()) != null) {
				while((index = str.indexOf(key,index))!=-1){   
		            //ÿѭ��һ�Σ���Ҫ��ȷ��һ�β��ҵ���ʼλ�á�  
		            index = index + key.length();  
		            //ÿ���ҵ�keyһ�Σ�count������  
		            count++;  
		        }  
			}
			System.out.println(key+"���ֵĴ���:"+count);
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ���ָ���ļ�");
		} catch (IOException e) {
			System.out.println("��ȡ�ļ�ʧ��");
		} finally {
			try {
				br.close();
				isr.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}