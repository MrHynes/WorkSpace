package laerningJava.chapter01;
import java.io.File;
public class testFileIterator {

	/**
	 * @param args
	 */
	static int j=0;
	public static void listFile(File f){
		//�ж��Ƿ�Ϊ��Ŀ¼
		if(f!=null){
			//�Ƿ���Ŀ¼
			if(f.isDirectory()){
				//�����Ŀ¼. �ݹ�
				File files[]=f.listFiles();
				if(f!=null){
					for(int i=0;i<files.length;i++)
						listFile(files[i]);
				}
				//����Ŀ¼��ֱ������ļ�����
			}else{
				j++;
				System.out.println(f);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����Ŀ¼
		/*
		File file=new File("d:\\java");
		File files[]=file.listFiles();
		for(int i=0;i<files.length;i++){
			System.out.println(files[i]);
		}
		*/
		File file=new File("D://��Ӱ");
		listFile(file);
		//ͳ�ƹ��ж��ٸ��ļ� Ŀ¼
		System.out.println(j);
	}
}
