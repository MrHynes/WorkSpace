package Chapter12_BufferReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CInputData {
	private BufferedReader br = null;

	public CInputData() {
		// TODO Auto-generated constructor stub
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public String getString(String info) throws Exception {
		System.out.println(info);
		String temp;
		temp = this.br.readLine();
		return temp;
	}

	public int getInt(String info, String err) throws Exception {
		int temp = 0;
		boolean flag = true;
		while (flag) {
			String string = getString(info);
			if (string.matches("^\\d+$")) {
				temp = Integer.parseInt(string);
				flag=false;
			} else {
				System.out.println(err);
			}
		}
		return temp;
	}
	
	public float getFloat(String info, String err) throws Exception {
		float temp = 0;
		boolean flag = true;
		while (flag) {
			String string = getString(info);
			if (string.matches("^\\d+.?\\d+$")) {
				temp = Integer.parseInt(string);
				flag=false;
			} else {
				System.out.println(err);
			}
		}
		return temp;
	}
	
	public Date getDate(String info, String err) throws Exception {
		Date d=null;
		String string=null;
		boolean flag = true;
		while (flag) {
			string = getString(info);
			if (string.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				d=sdf.parse(string);
				flag=false;
			} else {
				System.out.println(err);
			}
		}
		return d;
	}

}
