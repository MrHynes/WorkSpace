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
		System.out.println("1.ִ�й��췽��...");
	}
	public void setName(String name) {
		System.out.println("2.ע������...");
		this.name = name;
	}
	@Override
	public void setBeanName(String arg0) {
		System.out.println("3.ע���������Ե���:"+arg0);
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("4.ע��ApplicationContext:"+arg0);
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("6.�������ú�ִ��...");
	}
	public void initBean(){
		System.out.println("7.��ʼ������ִ��...");
	}
	public void sayHello(){
		System.out.println("9.ִ��ҵ����...");
		System.out.println("sayHello()����...");
	}
	@Override
	public void dispose() {
		System.out.println("10.����destroy()����...");
	}
	public void destroyBean(){
		System.out.println("11.�����ֶ�д�����ٷ���...");
	}
	public void setup(){
		System.out.println("7:�����ֶ����õĳ�ʼ������...");
	}

}