package pers.qiqcheng.spring.demo09;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CGLibProxy  implements MethodInterceptor{

	private ProductDao productDao;
	public CGLibProxy(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	public ProductDao createProxy(){
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(productDao.getClass());
		enhancer.setCallback(this);
		return (ProductDao)enhancer.create();
	}
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		if("add".equals(method.getName())){
			System.out.println("log...");
			Object obj=methodProxy.invokeSuper(proxy, args);
			return obj;
		}
		return methodProxy.invokeSuper(proxy, args);
	}

}
