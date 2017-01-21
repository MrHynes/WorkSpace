import java.io.*;
public class createFile {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file= new File("E:\\file.txt");
		try{
			boolean b=file.createNewFile();
			if(b){
				System.out.println("已经建立文件："+file.getAbsolutePath());
			}
			else{
			System.out.println("文件已经存在："+file.getAbsolutePath());
			}
		}catch(IOException e){
			System.out.print("失败");
		}
		
		File targetFile=new File("E:\\java.txt");
		//修改文件名称
		file.renameTo(targetFile);
		System.out.println("已经改名为："+targetFile.getName());
		//删除文件
			if(targetFile.delete()){
			System.out.println("删除文件成功"+targetFile.getAbsolutePath());
		}else{
			System.out.println("删除文件失败"+targetFile.getAbsolutePath());
		}
		//判断文件是否存在
		if(!targetFile.exists()){
			System.out.println("文件不存在"+targetFile.getAbsolutePath());
		}
		//删除文件
		if(targetFile.delete()){
			System.out.println("删除文件成功"+targetFile.getAbsolutePath());
		}else{
			System.out.println("删除文件失败"+targetFile.getAbsolutePath());
		}
	}
}
