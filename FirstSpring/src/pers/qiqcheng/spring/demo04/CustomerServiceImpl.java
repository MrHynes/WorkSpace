package pers.qiqcheng.spring.demo04;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sun.media.jfxmediaimpl.MediaDisposer.Disposable;

public class CustomerServiceImpl implements CustomerService, BeanNameAware,ApplicationContextAware,InitializingBean,Disposable{
	private String name;
	public CustomerServiceImpl(){
		System.out.println("1.执行构造方法...");
	}
	public void setName(String name) {
		System.out.println("2.注入属性...");
		this.name = name;
	}
	@Override
	public void setBeanName(String arg0) {
		System.out.println("3.注入配置属性的类:"+arg0);
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("4.注入ApplicationContext:"+arg0);
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("6.属性设置后执行...");
	}
	public void initBean(){
		System.out.println("7.初始化方法执行...");
	}
	public void sayHello(){
		System.out.println("9.执行业务处理...");
		System.out.println("sayHello()方法...");
	}
	@Override
	public void dispose() {
		System.out.println("10.调用destroy()方法...");
	}
	public void destroyBean(){
		System.out.println("11.调用手动写的销毁方法...");
	}
	public void setup(){
		System.out.println("7:调用手动设置的初始化方法...");
	}

}
