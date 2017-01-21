package Chapter16_Annotation;

public @interface MyAnnotation {
	public String key() default "123";
	public String value() default "abc";
	public type name()default type.CHENG;

}
