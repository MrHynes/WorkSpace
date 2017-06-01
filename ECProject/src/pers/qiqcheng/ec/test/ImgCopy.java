package pers.qiqcheng.ec.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImgCopy {

	public static void copyImgToFile(String imgName) {
		// 1.提供读入和写入的文件
		File f1 = new File("F:\\WorkSpace\\ECProject\\WebContent\\simg\\"+imgName);
		File f2 = new File("F:\\WorkSpace\\ECProject\\WebContent\\img\\"+imgName);
		/*File f1 = new File("F:\\src\\"+imgName);
		File f2 = new File("F:\\dest\\"+imgName);*/
		// 2.提供相应的流对象
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(f1);
			fos = new FileOutputStream(f2);
			// 3.实现复制
			byte[] b = new byte[200];
			int len;
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		copyImgToFile("20170601235054.jpg");
	}
}
