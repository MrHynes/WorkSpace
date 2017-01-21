package Chapter12_Scanner;

import java.io.File;
import java.util.Scanner;

public class CScanner {
	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.println("输入一个整数");
		if(scanner.hasNextInt()){
			int i=scanner.nextInt();
			System.out.println(i);
		}
		System.out.println("输入一个浮点数");
		if(scanner.hasNextFloat()){
			float j=scanner.nextFloat();
			System.out.println(j);
		}
		File f = new File("F:" + File.separator + "WorkSpace" + File.separator + "JavaProject" + File.separator
				+ "src" + File.separator + "Chapter12_Scanner" + File.separator + "f.txt");
		Scanner sc=new Scanner(f);
		StringBuffer sb=new StringBuffer();
		while(sc.hasNext()){
			sb.append(sc.next()).append("\n");
		}
		System.out.println(sb);
	}

}
