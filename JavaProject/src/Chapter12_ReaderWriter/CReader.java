package Chapter12_ReaderWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class CReader {
	public static void main(String[] args) throws Exception {
		File file = new File("F:" + File.separator + "WorkSpace" + File.separator + "JavaProject" + File.separator
				+ "src" + File.separator + "Chapter12_ReaderWriter" + File.separator + "f.txt");
		Reader reader=new FileReader(file);
		
		char b[]=new char[1000];
		/*
		int len=reader.read(b);
		reader.close();
		System.out.println(new String(b,0,len));
		*/
		//
		int temp;
		int i=0;
		while((temp=reader.read())!=-1){
			b[i]=(char) temp;
			i++;
		}
		//int count=0,index=0;
		System.out.println(new String(b,0,i));
		/*String string=new String(b,0,i);
		String key="婚";
		if(string.indexOf("婚")!=-1){
			count++;
		}
		while((index = string.indexOf(key,index))!=-1){  
            
            //每循环一次，就要明确下一次查找的起始位置。  
            index = index + key.length();  
            //每查找一次，count自增。  
            count++;  
        }  
		System.out.println("count:"+count);*/

	}

}
