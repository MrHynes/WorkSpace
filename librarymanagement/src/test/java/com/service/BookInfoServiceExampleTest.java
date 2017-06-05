package com.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class BookInfoServiceExampleTest {
	@Resource
	private BookInfoService bookInfoServiceExample;

	@Test
	public void update() {
		bookInfoServiceExample.update(99.10f, 1);
	}
}
