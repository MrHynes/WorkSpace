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
		
		char b[]=new char[1024];
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
		System.out.println(new String(b,0,i));
	}

}
