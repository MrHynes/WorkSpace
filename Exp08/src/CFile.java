import java.io.File;
public class CFile {
	public static void main(String[] args) throws Exception {
		String path = "F:" + File.separator + "WorkSpace" + File.separator + "Exp08" + File.separator + "src"
				+ File.separator + "f1.txt";
		File file = new File(path);
		if (!file.exists()) {
			file.createNewFile();
		} else {
			file.delete();
		}
	}
}
