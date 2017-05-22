package pers.qiqcheng.ec.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class test2 {
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		Date date=new Date();
		String d=sdf.format(date);
		System.out.println(d);
		System.out.println(new Date());
	}

}
