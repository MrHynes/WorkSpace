package com.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.BookCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class BookCaseDaoTest {
	@Autowired
	private BookCaseDao bookCaseDao;

	/**
	 * 测试增加
	 */
	@Test
	public void testSave() {
		bookCaseDao.save(new BookCase(7, "右 B-1"));
	}

	/**
	 * 测试修改
	 */
	@Test
	public void testUpdate() {
		bookCaseDao.save(new BookCase(7, "右 B-2"));
	}

	/**
	 * 测试查询
	 */
	@Test
	public void testFind() {
		System.out.println("findOne:" + bookCaseDao.findOne(7));
		System.out.println("findAll:" + bookCaseDao.findAll());
	}

	/**
	 * 测试删除
	 */
	@Test
	public void testDelete() {
		bookCaseDao.delete(7);
	}
}
