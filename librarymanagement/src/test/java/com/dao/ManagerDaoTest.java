package com.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.Manager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class ManagerDaoTest {
	@Autowired
	private ManagerDao managerDao;

	/**
	 * 测试findByName()
	 */
	@Test
	public void findByName() {
		Manager manager = managerDao.findByName("admin");
		System.out.println(manager);
	}
}
