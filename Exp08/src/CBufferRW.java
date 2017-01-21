import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CBufferRW {
	public static void main(String[] args) throws Exception {
		String path = "F:" + File.separator + "WorkSpace" + File.separator + "Exp08" + File.separator + "src"
				+ File.separator + "f4.txt";
		File file = new File(path);
		BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));
		String string1="hello java1;";
		String string2="\r\nhello java2;";
		String string3="\r\nhello java3;";
		bufferedWriter.write(string1);
		bufferedWriter.write(string2);
		bufferedWriter.write(string3);
		bufferedWriter.close();
		
		BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
		String temp=null;
		while((temp=bufferedReader.readLine())!=null){
			System.out.println(temp);
		}
		bufferedReader.close();
	}

}
