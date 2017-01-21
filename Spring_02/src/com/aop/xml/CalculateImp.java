package com.aop.xml;

public class CalculateImp implements Calculate {

	@Override
	public int add(int i, int j) {
		int result=i+j;
		return result;
	}

	@Override
	public int sub(int i, int j) {
		int result=i-j;
		return result;
	}

}
