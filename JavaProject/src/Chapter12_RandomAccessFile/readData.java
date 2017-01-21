package Chapter12_RandomAccessFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class readData {
	public static void main(String[] args) throws Exception {
		String path = "F:" + File.separator + "WorkSpace" + File.separator + "JavaProject" + File.separator + "src"
				+ File.separator + "Chapter12_RandomAccessFile" + File.separator + "f.txt";
		File f = new File(path);
		RandomAccessFile file = new RandomAccessFile(f, "r");
		if (f.exists()) {
			int agex = 0;
			String namex = null;
			byte b[] = new byte[8];
			//第二个人的信息
			file.skipBytes(12);
			for (int i = 0; i < b.length; i++) {
				b[i] = file.readByte();
			}
			namex = new String(b);
			agex = file.readInt();
			System.out.println("第二个人的信息：姓名：" + namex + ",年龄" + agex);
			//第一个人的信息
			file.seek(0);
			for (int i = 0; i < b.length; i++) {
				b[i] = file.readByte();
			}
			namex = new String(b);
			agex = file.readInt();
			System.out.println("第一个人的信息：姓名：" + namex + ",年龄" + agex);
			//第三个人的信息
			file.skipBytes(12);
			for (int i = 0; i < b.length; i++) {
				b[i] = file.readByte();
			}
			namex = new String(b);
			agex = file.readInt();
			System.out.println("第三个人的信息：姓名：" + namex + ",年龄" + agex);
			
		}
		file.close();
	}
}