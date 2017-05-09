package pers.qiqcheng.spring.demo13;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

@Aspect
public class MyAspect {
	//前置通知
	public void before(){
		System.out.println("addbefore..");
	}
	//后置通知
	public int afterReturn(Object returnval){
		System.out.println("afterReturning.."+returnval);
		return (int)returnval;
	}
	//环绕通知
	public Object around(ProceedingJoinPoint point){
		System.out.println("aroundBefore..");
		Object object=null;
		try {
			object = point.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("aroundAfter..");
		return object;
	}
	//最终通知
	public void after(){
		System.out.println("after..");
	}
	public void throwexp(Throwable e){
		System.out.println("exception.."+e.getMessage());
	}
	
}
