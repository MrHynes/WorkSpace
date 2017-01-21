package Chapter15_reflect;

public class ClassMain {
	public static void main(String[] args) throws Exception {
		Class c1=Class.forName("Chapter15_reflect.CPerson");
		CPerson p=(CPerson)c1.newInstance();
		p.setName("cc");
		p.setAge(18);
		System.out.println(p.toString());
	}

}
