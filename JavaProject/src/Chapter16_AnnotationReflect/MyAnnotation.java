package Chapter16_AnnotationReflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	public String key() default "a";
	public String value() default "cheng";

}
