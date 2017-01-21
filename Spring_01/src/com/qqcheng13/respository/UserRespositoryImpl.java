package com.qqcheng13.respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qqcheng13.TestObject;

@Repository("userRespository")
public class UserRespositoryImpl implements UserRespository {
	
	private TestObject testObject;
	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserRespository save...");
		System.out.println(testObject);
	}

}
