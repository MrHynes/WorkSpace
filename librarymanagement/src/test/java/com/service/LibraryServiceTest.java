package com.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class LibraryServiceTest {
	@Resource
	private LibraryService libraryService;

	@Test
	public void findOne() {
		System.out.println(libraryService.findOne());
	}
}
