package Chapter12_File;

import java.io.File;
import java.lang.reflect.Field;

public class printAllFileDirectory {
	public static void main(String[] args) {
		String path = "F:" + File.separator + "WorkSpace" + File.separator + "JavaProject" + File.separator + "src";
		File f = new File(path);
		print(f);
	}

	public static void print(File f) {
		if(f!=null){
			if(f.isDirectory()){
				File str[]=f.listFiles();
				if(f!=null){
					for (File file : str) {
						print(file);
					}
				}
			}else{
				System.out.println(f);
			}
		}	
	}
}
