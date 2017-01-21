package com.qqcheng14;

import org.springframework.beans.factory.annotation.Autowired;

public class baseService<T> {
	@Autowired
	protected baseRepository<T> repository;
	public void add(){
		System.out.println("add..");
		System.out.println(repository);
	}

}
