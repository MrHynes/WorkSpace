package CDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynaminProxyHander implements InvocationHandler {

	private Object obj;

	public Object bind(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(this.obj.getClass().getClassLoader(),this.obj.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object result=null;
		result=method.invoke(this.obj, args);
		return result;
	}

}
