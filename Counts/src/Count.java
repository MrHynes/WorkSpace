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
		BufferedReader br = null; // 用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
		try {
			String str = "";
			String key="a";
			int index=0;
			int count=0;
			fis = new FileInputStream("F:" + File.separator + "WorkSpace" + File.separator + "Counts" + File.separator
					+ "src" + File.separator + "file.txt");// FileInputStream
			// 从文件系统中的某个文件中获取字节
			isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
			br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new
											// InputStreamReader的对象
			//每次循环读取文件一行内容
			while ((str = br.readLine()) != null) {
				while((index = str.indexOf(key,index))!=-1){   
		            //每循环一次，就要明确下一次查找的起始位置。  
		            index = index + key.length();  
		            //每查找到key一次，count自增。  
		            count++;  
		        }  
			}
			System.out.println(key+"出现的次数:"+count);
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件");
		} catch (IOException e) {
			System.out.println("读取文件失败");
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
