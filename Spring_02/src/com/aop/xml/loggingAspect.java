package com.aop.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class loggingAspect {
	
	
	public void declareJoinPointExpression(){
	}
	
	
	public void beforeMethod(JoinPoint joinpoint){
		String methodName=joinpoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinpoint.getArgs());
		System.out.println("The method "+methodName+" begins with"+args);
	}
	
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends");
	}
	
	
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ensd with "+result);
	}
	
	public void  afterThrowimg(JoinPoint joinPoint,Exception ex){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occurs execption: "+ex);
	}
	
	public Object aroundMethod(ProceedingJoinPoint pjd){	
		Object result=null;
		String methodName=pjd.getSignature().getName();
		//ִ��Ŀ�귽��
		try {
			//ǰ��֪ͨ
			System.out.println("The method "+methodName+" begins with"+Arrays.asList(pjd.getArgs()));
			//ִ��Ŀ�귽��
			result=pjd.proceed();
			//����֪ͨ
			System.out.println("The method "+methodName+" ends with "+ result);
		} catch (Throwable e) {
			// TODO: handle exception
			//�쳣֪ͨ
			System.out.println("The method "+methodName+" occurs execption: "+e);
		}
		//����֪ͨ
		System.out.println("The method "+methodName+" ends");
		return result;
	}

}
