package pers.qiqcheng.qrcode;
import java.io.IOException;
import com.google.zxing.WriterException;
//http://kesun-shy.iteye.com/blog/2154169 �ο�
public class main {
public static void main(String[] args) {
	RecognitionQRCode recognitionQRCode=new RecognitionQRCode();
	try {
		recognitionQRCode.QREncode();
	} catch (WriterException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	recognitionQRCode.QRDecode();
}
}
