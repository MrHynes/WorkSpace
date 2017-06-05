package com.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.Manager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class ManagerServiceImplTest {
	@Resource
	private ManagerService managerService;

	@Test
	public void managerLogin() {
		Manager manager = new Manager();
		manager.setName("mr");
		manager.setPWD("mrsoft");
		System.out.println(managerService.managerLogin(manager));

	}
}
