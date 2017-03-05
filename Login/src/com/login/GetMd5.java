package com.login;

public class GetMd5 {

	public static void main(String[] args) {
		String str="hello{yootk}";
		String md5=new MD5Code().getMD5ofStr(str);
		System.out.println(md5);
	}
}
