import java.io.File;

public class getFileSuxing {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("E:\\test.txt");
		System.out.println("���ļ������֣�"+file.getName());
		System.out.println("���ļ��ľ���·��"+file.getAbsolutePath());
		System.out.println("���ļ��ĸ�Ŀ¼����"+file.getParent());
		System.out.println("���ļ���·��"+file.getPath());
		System.out.println("���ļ��Ĺ�ϣ��"+file.hashCode());
		System.out.println("���ļ��ĳ��ȣ��ֽڣ�"+file.length());
		System.out.println("���ļ������һ���޸�ʱ��"+file.lastModified());
	}
}