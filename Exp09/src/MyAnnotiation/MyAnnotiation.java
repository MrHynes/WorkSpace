package MyAnnotiation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME)
public @interface MyAnnotiation {
	public String key()default "a";
	public String value() default "A";
}
