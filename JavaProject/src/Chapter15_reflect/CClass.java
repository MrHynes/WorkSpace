package Chapter15_reflect;

import java.lang.reflect.Constructor;

class X{
	private String name;
	public X() {
		// TODO Auto-generated constructor stub
	}
	public X(String name){
		this.name=name;
	}
	public String getname(){
		return name;
	}

}
public class CClass {
	public static void main(String[] args) {
		X xs=new X();
		System.out.println(xs.getClass().getName());
		Class class1=xs.getClass();
		System.out.println(class1.getName());
		Constructor []c=class1.getConstructors();
		for (Constructor constructor : c) {
			System.out.println(constructor.toString());
		}
		Class class2=null;
		try {
			class2=Class.forName("Chapter15_reflect.X");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(class2.getName());
		
	}
}
