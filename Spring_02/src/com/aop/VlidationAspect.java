package com.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//��֤֪ͨ
@Order(1)//ָ���������ȣ�ֵԽС���ȼ�Խ��
@Aspect
@Component
public class VlidationAspect {
	@Before("loggingAspect.declareJoinPointExpression()")
	public void validataArgs(JoinPoint joinPoint){
		System.out.println("-->validate: "+Arrays.asList(joinPoint.getArgs()));
	}

}
