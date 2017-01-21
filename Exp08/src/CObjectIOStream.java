import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CObjectIOStream {
	public static void main(String[] args) throws Exception, IOException {
		String path = "F:" + File.separator + "WorkSpace" + File.separator + "Exp08" + File.separator + "src"
				+ File.separator + "f7.dat";
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(new CStudent("chengqi", 19));
		oos.writeObject(new CStudent("lilili", 21));
		oos.flush();
		oos.close();
		
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(path));
		CStudent student=(CStudent)ois.readObject();
		System.out.println(student);
		CStudent student2=(CStudent)ois.readObject();
		System.out.println(student2);
		ois.close();
	}
}
