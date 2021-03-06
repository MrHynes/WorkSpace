package pers.qiqcheng.spring.demo14;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class JDBCTemplate {
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Test
	public void test1(){
		jdbcTemplate.execute("create table user(id int,name varchar(5))");
	}
	//DBCP
	@Autowired
	@Qualifier("jdbcTemplate2")
	private JdbcTemplate jdbcTemplate2;
	@Test
	public void test2(){
		jdbcTemplate2.execute("create table user(id int,name varchar(6))");
	}
	
	//c3p0
	@Autowired
	@Qualifier("jdbcTemplate3")
	private JdbcTemplate jdbcTemplate3;
	@Test
	public void test3(){
		jdbcTemplate3.execute("create table user(id int,name varchar(7))");
	}
	//将参数保存在properties文件中
	@Autowired
	@Qualifier("jdbcTemplate4")
	private JdbcTemplate jdbcTemplate4;
	@Test
	public void test4(){
		jdbcTemplate3.execute("create table user(id int,name varchar(8))");
	}

	@Test
	public void test() {
		//创建连接池
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		//配置参数
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///student");
		dataSource.setUsername("root");
		dataSource.setPassword("chengqi");
		//使用JDBC模板
		JdbcTemplate template=new JdbcTemplate(dataSource);
		template.execute("create table user(id int,name varchar(10))");
	}

}
