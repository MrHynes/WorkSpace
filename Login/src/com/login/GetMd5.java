package com.login;

public class GetMd5 {

	public static void main(String[] args) {
		String str="123456{cheng}";
		//req.getParameter("pass")+"{"+username+"}"
		String p="123456";
		String username="chengqi";
		String str2=p+"{"+username+"}";
		String md5=new MD5Code().getMD5ofStr(str);
		System.out.println(md5);
		
	}
}
