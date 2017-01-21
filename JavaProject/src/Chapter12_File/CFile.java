package Chapter12_File;

import java.io.File;
import java.io.IOException;

public class CFile {
	public static void main(String[] args) {
		// windows和lin,ux中的分分隔符不一样，windows的分隔符是反斜杠\，而linux中的分隔符是正斜杠/。为了保证java的可移植性，所以使用File.separator
		String path = "F:" + File.separator + "WorkSpace" + File.separator + "JavaProject" + File.separator + "src"
				+ File.separator + "Chapter13_File" + File.separator + "f.txt";
		File f = new File(path);
		if (!f.exists()) {
			try {
				f.createNewFile();
				System.out.println("f.txt创建成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("存在f.txt文件");
			f.delete();
			System.out.println("f.txt已经删除");
		}

	}

}
