package pers.qiqcheng.spring.demo04;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 后处理bean
 * @author Buer
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("8.初始化之后执行...");
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("5.初始化之前执行...");
		if(beanName.equals("customerService")){
			Object proxy=Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					if("sayHello".equals(method.getName())){
						System.out.println("权限检验...");
						Object result=method.invoke(bean, args);
						return result;
					}
					return method.invoke(bean, args);
				}
			});
			return proxy;
		}
		return bean;
	}

}
