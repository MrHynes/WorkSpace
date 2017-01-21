package com.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//验证通知
@Order(1)//指定切面优先，值越小优先级越高
@Aspect
@Component
public class VlidationAspect {
	@Before("loggingAspect.declareJoinPointExpression()")
	public void validataArgs(JoinPoint joinPoint){
		System.out.println("-->validate: "+Arrays.asList(joinPoint.getArgs()));
	}

}
