package pers.qiqcheng.spring.demo15;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class SpringTest {
	@Autowired
	@Qualifier("userdao")
	private UserDao userDao;
	@Test
	public void test1(){
		User user=new User();
		user.setId(1);
		user.setName("cheng");
		userDao.add(user);
	}
	@Test
	public void test2(){
		User user=new User();
		user.setId(1);
		user.setName("ccc");
		userDao.update(user);
	}
	@Test
	public void test3(){
		User user=new User();
		user.setId(1);
		userDao.delete(user);
	}
	@Test
	public void test4(){
		System.out.println("Count:"+userDao.findCount());
	}
	@Test
	public void test5(){
		System.out.println(userDao.findNameByID(2));
	}

	@Test
	public void test6(){
		User user=userDao.findUserByID(4);
		System.out.println(user.toString());
	}
	@Test
	public void test8(){
		List<User>list=new ArrayList<>();
		list=userDao.findAll();
		for (User user : list) {
			System.out.println(user.toString());
		}
	}
}
