package pers.qiqcheng.spring.demo19;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext7.xml")
public class SpringTest {
	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;
	@Test
	public void test(){
		accountService.transfer("bbb", "ccc", 100d);
	}

}