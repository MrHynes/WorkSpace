package pers.qiqcheng.spring.demo06;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//通过注解方式定义bean
@Component("helloService")
//@Scope
@Scope(value="prototype")
public class HelloService {
	@Autowired
	@Qualifier("user")
	//还可以使用@Resource(name="user")  代替@Autowired @Qualifier("user")
	private User user;
	@Value("chengqi")
	private String name;
	public void sayHllo(){
		System.out.println("Hello World");
	}
	@Override
	public String toString() {
		return "HelloService [user=" + user + ", name=" + name + "]";
	}
	
	//初始化方法
	@PostConstruct
	public void init(){
		System.out.println("初始化..");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("销毁...");
	}

}
