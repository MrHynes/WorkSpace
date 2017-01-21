package Chapter16_AnnotationReflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class getAllAnnotation {
	public static void main(String[] args) throws Exception {
		Class class1=null;
		class1=Class.forName("Chapter16_AnnotationReflect.testAnn");
		Method method=class1.getMethod("toString");
		Annotation an[]=method.getAnnotations();
		for (Annotation annotation : an) {
			System.out.println(annotation);
			
		}
	}

}
