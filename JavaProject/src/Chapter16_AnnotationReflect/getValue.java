package Chapter16_AnnotationReflect;

import java.lang.reflect.Method;

public class getValue {
	public static void main(String[] args) throws Exception {
		Class class1=Class.forName("Chapter16_AnnotationReflect.testMyAnnotation");
		Method method=class1.getMethod("toString");
		if(method.isAnnotationPresent(MyAnnotation.class)){
			MyAnnotation mann=null;
			mann=method.getAnnotation(MyAnnotation.class);
			String key=mann.key();
			String value=mann.value();
			System.out.println("key:"+key+" value:"+value);
		}
	}

}
