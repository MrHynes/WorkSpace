package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class ProxyHandler implements InvocationHandler {

	Object obj;
	public Object bind(Object obj){//绑定真实操作对象
		this.obj=obj;
		//取得代理对象
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object temp=method.invoke(this.obj, args);
		return temp;
	}

}
