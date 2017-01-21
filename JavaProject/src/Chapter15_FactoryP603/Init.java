package Chapter15_FactoryP603;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Init {
	public static Properties getPro() throws Exception{
		String path="F:"+File.separator+"WorkSpace"+File.separator+"JavaProject"+File.separator+
				"src"+File.separator+"Chapter15_FactoryP603"+File.separator+"fruit.properties";
		Properties pro=new Properties();
		File file=new File(path);
		if(file.exists()){
			pro.load(new FileInputStream(file));
		}else{
			pro.setProperty("apple", "Chapter15_FactoryP603.Apple");
			pro.setProperty("Orange", "Chapter15_FactoryP603.Orange");
			pro.store(new FileOutputStream(file), "FRUIT CLASS");
		}
		return pro;
	}

}
