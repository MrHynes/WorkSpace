import java.io.*;
public class createFile {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file= new File("E:\\file.txt");
		try{
			boolean b=file.createNewFile();
			if(b){
				System.out.println("�Ѿ������ļ���"+file.getAbsolutePath());
			}
			else{
			System.out.println("�ļ��Ѿ����ڣ�"+file.getAbsolutePath());
			}
		}catch(IOException e){
			System.out.print("ʧ��");
		}
		
		File targetFile=new File("E:\\java.txt");
		//�޸��ļ�����
		file.renameTo(targetFile);
		System.out.println("�Ѿ�����Ϊ��"+targetFile.getName());
		//ɾ���ļ�
			if(targetFile.delete()){
			System.out.println("ɾ���ļ��ɹ�"+targetFile.getAbsolutePath());
		}else{
			System.out.println("ɾ���ļ�ʧ��"+targetFile.getAbsolutePath());
		}
		//�ж��ļ��Ƿ����
		if(!targetFile.exists()){
			System.out.println("�ļ�������"+targetFile.getAbsolutePath());
		}
		//ɾ���ļ�
		if(targetFile.delete()){
			System.out.println("ɾ���ļ��ɹ�"+targetFile.getAbsolutePath());
		}else{
			System.out.println("ɾ���ļ�ʧ��"+targetFile.getAbsolutePath());
		}
	}
}
