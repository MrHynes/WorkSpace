package Chapter12_File;

import java.io.File;
import java.io.IOException;

public class CFile {
	public static void main(String[] args) {
		// windows��lin,ux�еķַָ�����һ����windows�ķָ����Ƿ�б��\����linux�еķָ�������б��/��Ϊ�˱�֤java�Ŀ���ֲ�ԣ�����ʹ��File.separator
		String path = "F:" + File.separator + "WorkSpace" + File.separator + "JavaProject" + File.separator + "src"
				+ File.separator + "Chapter13_File" + File.separator + "f.txt";
		File f = new File(path);
		if (!f.exists()) {
			try {
				f.createNewFile();
				System.out.println("f.txt�����ɹ�");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("����f.txt�ļ�");
			f.delete();
			System.out.println("f.txt�Ѿ�ɾ��");
		}

	}

}
