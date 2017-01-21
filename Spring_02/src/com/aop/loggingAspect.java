package com.aop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//把这个类申明为切面.1.需要把该类放到ioc容器中 @Component  2.申明为一个切面 @aspect
@Order(2)//指定切面优先级，值越小优先级越高
@Aspect
@Component
public class loggingAspect {
	
	//定义一个方法申明切入点表达式，一般的，改方法不需要添加代码
	//使用@PointcutZ注解来申明切入点表达式
	//后面的其他通知直接使用方法名来引用当前的切入点表达式。
	@Pointcut("execution(public int com.aop.CalculateImp.*(int, int))")
	public void declareJoinPointExpression(){
	}
	
	//申明该方法为前置通知，在目标方法开始之前执行
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinpoint){
		String methodName=joinpoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinpoint.getArgs());
		System.out.println("The method "+methodName+" begins with"+args);
	}
	//后置通知：在目标方法执行后（无论是否发送异常）执行的通知
	//后置通知访问不到方法的返回值的，因为方法可能会出异常
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends");
	}
	
	//返回通知,在方法正常结束后执行的代码
	//放回的通知是可以访问到方法的返回值的
	@AfterReturning(value="declareJoinPointExpression()",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ensd with "+result);
	}
	//异常通知
	//在方法出现异常时，会执行的代码，可以访问到异常对象，可以指定出现在特定异常时再执行通知代码
	@AfterThrowing(value="declareJoinPointExpression()",throwing="ex")
	public void  afterThrowimg(JoinPoint joinPoint,Exception ex){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occurs execption: "+ex);
	}
	/*
	//环绕通知,环绕方法执行(功能最强，但是不常用)
	//环绕通知需要携带ProceedingJoinPoint类型参数
	//环绕通知类似动态代理的全过程ProceedingJoinPoint类型的参数可以决定是否执行目标方法
	//且环绕通知必须有返回值，返回值为目标方法的返回值
	@Around("execution(public int com.aop.CalculateImp.*(int, int))")
	public Object aroundMethod(ProceedingJoinPoint pjd){	
		Object result=null;
		String methodName=pjd.getSignature().getName();
		//执行目标方法
		try {
			//前置通知
			System.out.println("The method "+methodName+"begins with "+Arrays.asList(pjd.getArgs()));
			//执行目标方法
			result=pjd.proceed();
			//返回通知
			System.out.println("The method "+methodName+" ends with "+ result);
		} catch (Throwable e) {
			// TODO: handle exception
			//异常通知
			System.out.println("The method "+methodName+" occurs execption: "+e);
		}
		//后置通知
		System.out.println("The method "+methodName+" ends");
		return result;
	}
	*/
}
