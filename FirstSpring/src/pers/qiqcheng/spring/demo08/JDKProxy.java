package pers.qiqcheng.spring.demo08;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

	private UserDao userdao;
	
	public JDKProxy(UserDao userdao) {
		super();
		this.userdao = userdao;
	}

	public UserDao createProxy(){
		UserDao proxy=(UserDao) Proxy.newProxyInstance(userdao.getClass().getClassLoader(), userdao.getClass().getInterfaces(), this);
		return proxy;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if("add".equals(method.getName())){
			System.out.println("log...");
			Object result=method.invoke(userdao, args);
			return result;
		}
		return method.invoke(userdao, args);
	}

}
