package Chapter12_BufferReader;

import java.util.Date;

public class mainCInputData {

	public static void main(String[] args) throws Exception {
		CInputData inputData=new CInputData();
		Date d1=null;
		d1=inputData.getDate("输入", "输入有误，请重新输入");
		System.out.println(d1.toString());
	}
}
