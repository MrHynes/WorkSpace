package com.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookInfoDaoExample;
import com.service.BookInfoService;

@Service("bookInfoServiceExample")
public class BookInfoServiceImplEaxmple implements BookInfoService {
	@Autowired
	private BookInfoDaoExample bookInfoDaoExample;

	@Transactional
	public void update(float price, Integer id) {
		bookInfoDaoExample.update(price, id);
	}

}
