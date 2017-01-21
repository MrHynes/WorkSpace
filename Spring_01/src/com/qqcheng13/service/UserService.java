package com.qqcheng13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qqcheng13.respository.UserRespository;
@Service
public class UserService {
	@Autowired
	private UserRespository userRespository;
	public void add(){
		System.out.println("UserService add...");
		userRespository.save();
	}

}
