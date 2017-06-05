package com.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.BookCase;
import com.entity.BookInfo;
import com.entity.BookType;
import com.entity.Publishing;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class BookInfoDaoTest {
	@Autowired
	private BookInfoDao bookInfoDao;

	@Test
	public void save() throws Exception {
		Publishing p = new Publishing("111", "机械工业出版社");
		BookType booktype = new BookType("网络编程", 20);
		BookCase bookcase = new BookCase(4, "左 A-1");
		BookInfo bookInfo = new BookInfo(7, "9787302210337", "Java Web开发实战宝典", "王国辉", "", 89.00f, 834, "mr", false);
		bookInfo.setISBN(p);
		bookInfo.setBooktype(booktype);
		bookInfo.setBookcase(bookcase);
		bookInfoDao.save(bookInfo);
	}
}
