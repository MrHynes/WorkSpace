package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Library;
import com.service.LibraryService;

@Controller
@RequestMapping("/library")
public class LibraryController {
	@Resource
	private LibraryService libraryService;

	@RequestMapping("/info")
	@ResponseBody
	public Library libraryInfo() {
		return libraryService.findOne();
	}

	@RequestMapping("/save")
	@ResponseBody
	public Library librarySave(Library library) {
		return libraryService.save(library);
	}
}
