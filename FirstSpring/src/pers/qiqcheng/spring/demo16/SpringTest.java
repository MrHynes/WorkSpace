package pers.qiqcheng.spring.demo16;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext4.xml")
public class SpringTest {
	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;
	@Test
	public void test(){
		//ת��ת��
		accountService.transfer("ccc", "bbb", 100d);
	}

}