import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;

public class CPrintStreamWriter {
	public static void main(String[] args) throws Exception {
		//��ӡ�������ַ���ӡ�� PrintWriter �ֽڴ�ӡ��PrintStream
		String path1 = "F:" + File.separator + "WorkSpace" + File.separator + "Exp08" + File.separator + "src"
				+ File.separator + "f5.1.txt";
		String path2 = "F:" + File.separator + "WorkSpace" + File.separator + "Exp08" + File.separator + "src"
				+ File.separator + "f5.2.txt";
		PrintStream ps=new PrintStream(new File(path1));
		ps.print("hello java1;");
		ps.println("hello java2;");
		ps.printf("������%s ���䣺%d;","����",19);
		ps.close();
		
		PrintWriter pw=new PrintWriter(new File(path2));
		pw.print("hello java1");
		pw.println("hello java2");
		pw.printf("������%s ���䣺%d;","����",19);
		pw.close();
	}

}
