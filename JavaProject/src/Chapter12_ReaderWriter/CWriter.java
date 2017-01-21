package Chapter12_ReaderWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.channels.WritableByteChannel;

public class CWriter {
	public static void main(String[] args) throws Exception {
		File file = new File("F:" + File.separator + "WorkSpace" + File.separator + "JavaProject" + File.separator
				+ "src" + File.separator + "Chapter12_ReaderWriter" + File.separator + "f.txt");
		Writer writer=new FileWriter(file,true);
		String str="\r\nnew String\r\n";
		writer.write(str);
		char b[]={'n','e','w','s','t','r','i','n','g','2'};
		writer.write(b);
		writer.close();
	}

}
