package Chapter16_AnnotationReflect;

public class testMyAnnotation {
	@SuppressWarnings("unchecked")
	@Deprecated
	@Override
	@MyAnnotation(value="chengqi",key="abc")
	public String toString() {
		// TODO Auto-generated method stub
		return "hh";
	}

}
