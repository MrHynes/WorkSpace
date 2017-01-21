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

//�����������Ϊ����.1.��Ҫ�Ѹ���ŵ�ioc������ @Component  2.����Ϊһ������ @aspect
@Order(2)//ָ���������ȼ���ֵԽС���ȼ�Խ��
@Aspect
@Component
public class loggingAspect {
	
	//����һ�����������������ʽ��һ��ģ��ķ�������Ҫ��Ӵ���
	//ʹ��@PointcutZע���������������ʽ
	//���������ֱ֪ͨ��ʹ�÷����������õ�ǰ���������ʽ��
	@Pointcut("execution(public int com.aop.CalculateImp.*(int, int))")
	public void declareJoinPointExpression(){
	}
	
	//�����÷���Ϊǰ��֪ͨ����Ŀ�귽����ʼ֮ǰִ��
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinpoint){
		String methodName=joinpoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinpoint.getArgs());
		System.out.println("The method "+methodName+" begins with"+args);
	}
	//����֪ͨ����Ŀ�귽��ִ�к������Ƿ����쳣��ִ�е�֪ͨ
	//����֪ͨ���ʲ��������ķ���ֵ�ģ���Ϊ�������ܻ���쳣
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends");
	}
	
	//����֪ͨ,�ڷ�������������ִ�еĴ���
	//�Żص�֪ͨ�ǿ��Է��ʵ������ķ���ֵ��
	@AfterReturning(value="declareJoinPointExpression()",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ensd with "+result);
	}
	//�쳣֪ͨ
	//�ڷ��������쳣ʱ����ִ�еĴ��룬���Է��ʵ��쳣���󣬿���ָ���������ض��쳣ʱ��ִ��֪ͨ����
	@AfterThrowing(value="declareJoinPointExpression()",throwing="ex")
	public void  afterThrowimg(JoinPoint joinPoint,Exception ex){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occurs execption: "+ex);
	}
	/*
	//����֪ͨ,���Ʒ���ִ��(������ǿ�����ǲ�����)
	//����֪ͨ��ҪЯ��ProceedingJoinPoint���Ͳ���
	//����֪ͨ���ƶ�̬�����ȫ����ProceedingJoinPoint���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�귽��
	//�һ���֪ͨ�����з���ֵ������ֵΪĿ�귽���ķ���ֵ
	@Around("execution(public int com.aop.CalculateImp.*(int, int))")
	public Object aroundMethod(ProceedingJoinPoint pjd){	
		Object result=null;
		String methodName=pjd.getSignature().getName();
		//ִ��Ŀ�귽��
		try {
			//ǰ��֪ͨ
			System.out.println("The method "+methodName+"begins with "+Arrays.asList(pjd.getArgs()));
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
	*/
}
