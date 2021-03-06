package pers.qiqcheng.zxing;

import java.io.File;
import java.util.Hashtable;
import java.util.Scanner;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCode {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String text = "你好";
		System.out.println("请输入信息：");
		text = scanner.next();
		int width = 100;
		int height = 100;
		String format = "png";
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
		File outputFile = new File("new.png");
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
		System.out.println("二维码生成成功！");
	}
}