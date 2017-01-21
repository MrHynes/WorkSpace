package Chapter12_File;

import java.io.File;

public class test {
	public static void main(String[] args) {
		String path = "F:" + File.separator + "WorkSpace" + File.separator + "JavaProject" + File.separator + "src";
		File file=new File(path);
		print(file);
	}
	public static void print(File f){
		if(f!=null){
			if(f.isDirectory()){
				File file[]=f.listFiles();
				if(file!=null){
					for(int i=0;i<file.length;i++){
						print(file[i]);
					}
				}
			}else{
				System.out.println(f);
			}
		}
	}

}
