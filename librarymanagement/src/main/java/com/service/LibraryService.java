package com.service;

import com.entity.Library;

public interface LibraryService {
	public Library findOne();

	public Library save(Library library);
}
