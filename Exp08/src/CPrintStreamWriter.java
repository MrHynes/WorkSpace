import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;

public class CPrintStreamWriter {
	public static void main(String[] args) throws Exception {
		//打印流包括字符打印流 PrintWriter 字节打印流PrintStream
		String path1 = "F:" + File.separator + "WorkSpace" + File.separator + "Exp08" + File.separator + "src"
				+ File.separator + "f5.1.txt";
		String path2 = "F:" + File.separator + "WorkSpace" + File.separator + "Exp08" + File.separator + "src"
				+ File.separator + "f5.2.txt";
		PrintStream ps=new PrintStream(new File(path1));
		ps.print("hello java1;");
		ps.println("hello java2;");
		ps.printf("姓名：%s 年龄：%d;","程祺",19);
		ps.close();
		
		PrintWriter pw=new PrintWriter(new File(path2));
		pw.print("hello java1");
		pw.println("hello java2");
		pw.printf("姓名：%s 年龄：%d;","程祺",19);
		pw.close();
	}

}
