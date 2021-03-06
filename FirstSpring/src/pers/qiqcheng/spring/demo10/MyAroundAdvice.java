package pers.qiqcheng.spring.demo10;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		System.out.println("method before..");
		Object result=method.proceed();
		System.out.println("method after...");
		return result;
	}

}
