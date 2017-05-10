package pers.qiqcheng.spring.demo12;

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
	//ǰ��֪ͨ
	@Before("execution(* pers.qiqcheng.spring.demo12.UserDao.add(..))")
	public void before(){
		System.out.println("addbefore..");
	}
	//����֪ͨ
	//@AfterReturning(value="execution(* pers.qiqcheng.spring.demo12.UserDao.update(..))",returning="returnval")
	//�����Ըĳ�
	@AfterReturning(value="MyAspect.myPointcutUpdate()",returning="returnval")
	public int afterReturn(Object returnval){
		System.out.println("afterReturning.."+returnval);
		return (int)returnval;
	}
	//����֪ͨ
	@Around("MyAspect.myPointcutDelete()")
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
	//����֪ͨ
	@After("MyAspect.myPointcutFind()")
	public void after(){
		System.out.println("after..");
	}
	//�׳��쳣֪ͨ
	@AfterThrowing(value="MyAspect.myPointcutThrowExp()",throwing="e")
	public void throwexp(Throwable e){
		System.out.println("exception.."+e.getMessage());
	}
	//�е��ע��
	@Pointcut("execution(* pers.qiqcheng.spring.demo12.UserDao.update(..))")
	private void myPointcutUpdate(){}
	@Pointcut("execution(* pers.qiqcheng.spring.demo12.UserDao.delete(..))")
	private void myPointcutDelete(){}
	@Pointcut("execution(* pers.qiqcheng.spring.demo12.UserDao.find(..))")
	private void myPointcutFind(){}
	@Pointcut("execution(* pers.qiqcheng.spring.demo12.UserDao.throwExp(..))")
	private void myPointcutThrowExp(){}
	
}