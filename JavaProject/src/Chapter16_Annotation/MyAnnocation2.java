package Chapter16_Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.SOURCE)
public @interface MyAnnocation2 {
	public String value()default "cheng";

}
