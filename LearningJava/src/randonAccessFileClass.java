import java.io.*;
public class randonAccessFileClass {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file=new File("E:\\java.txt");
		if(file.exists()){
			file.delete();
			file.createNewFile();
		}
		RandomAccessFile refile=new RandomAccessFile(file,"rw");
		refile.writeBytes("I Love Java");//���ļ���д������
		System.out.println(refile.getFilePointer());//	��ȡ�ļ���ǰλ�úͿ�ͷ��ƫ����
		for(int i=0;i<refile.length();i++){
			refile.seek(i);//�����ļ�ָ��
			System.out.print((char)refile.readByte());//���ָ�������ֽ�
		}
	}
}
