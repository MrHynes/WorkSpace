package com.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.Library;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class LibrartDaoTest {
	@Autowired
	private LibraryDao libraryDao;

	/**
	 * 测试save
	 */
	@Test
	public void save() {
		Library library = new Library(1, "博研图书馆", "mr", "0431-84978981", "长春市东盛大街89", "mingrisoft@mingsoft.com",
				"http://www", new java.sql.Date(new Date().getTime()), "本市拥有计算机类图书最多的图书馆。");
		libraryDao.save(library);

	}
	
	@Test
	public void save2() {
		Library library = new Library(2, "又玄图书馆", "admin", "0431-8", "长春市东盛大街", "mingrit@mingsoft.com",
				"http://www.123.com", new java.sql.Date(new Date().getTime()), "本市拥有计算最多的图书馆。");
		libraryDao.save(library);

	}

	/**
	 * 测试findOne
	 */
	@Test
	public void findOne() {
		System.out.println(libraryDao.findOne(1));
	}
}
