package pers.qiqcheng.bookstore.test;

import java.util.Arrays;

public class test2 {
public static void main(String[] args) {
	String params[]={"username","pass","relName","telNumber","code","address"};
	for(int i=1;i<params.length-1;i++){
		params[i]=params[i+1];
	}
	for (String string : params) {
		System.out.println(string);
	}
	System.out.println("-----------");
	params=Arrays.copyOf(params, params.length-1);
	for (String string : params) {
		System.out.println(string);
	}
	System.out.println(params.length);
}
}
