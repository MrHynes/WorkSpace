package MyAnnotiation;

import java.lang.reflect.Method;

public class GetAnnotation {
	public static void main(String[] args) throws Exception {
		Class c=null;
		c=Class.forName("MyAnnotiation.CDemo");
		Method method=c.getMethod("toString");
		if(method.isAnnotationPresent(MyAnnotiation.class)){
			MyAnnotiation ma=null;
			ma=method.getAnnotation(MyAnnotiation.class);
			String key=ma.key();
			String value=ma.value();
			System.out.println("key:"+key+" value:"+value);
		}
	}
}
