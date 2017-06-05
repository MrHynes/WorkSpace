package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LibraryDao;
import com.entity.Library;
import com.service.LibraryService;

@Service("libraryService")
public class LibraryServiceImpl implements LibraryService {
	@Autowired
	private LibraryDao libraryDao;

	public Library findOne() {
		return libraryDao.findOne(1);
	}

	public Library save(Library library) {
		return libraryDao.save(library);

	}
}
