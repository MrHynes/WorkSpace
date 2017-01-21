package Chapter15_Reflect_Class;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.jar.Attributes.Name;

public class CReflectOper {
	public static void main(String[] args) throws Exception {
		//通过反射调用类中的方法
		Class cstudent=Class.forName("Chapter15_Reflect_Class.CStudent");
		Method method=cstudent.getMethod("sayHello", String.class);
		method.invoke(cstudent.newInstance(), "liming");
		//调用get set方法
		Object obj=null;
		obj=cstudent.newInstance();
		setter(obj, "name", "chengqi", String.class);
		getter(obj, "name");
		
		
		//直接操作类中的属性
		Class c2=Class.forName("Chapter15_Reflect_Class.CStudent");
		Object cstudent2=c2.newInstance();
		Field name=c2.getDeclaredField("name");
		Field age=c2.getDeclaredField("age");
		name.setAccessible(true);
		name.set(cstudent2, "chengqi2");
		age.setAccessible(true);
		age.set(cstudent2, 19);
		System.out.println(name.get(cstudent2));
		System.out.println(age.get(cstudent2));
				
	}
	public static void setter(Object obj,String att,String value,Class type) throws Exception{
		Method method=obj.getClass().getMethod("set"+initStr(att),type);
		method.invoke(obj, value);
	}
	public static void getter(Object obj,String att) throws Exception{
		Method method=obj.getClass().getMethod("get"+initStr(att));
		System.out.println(method.invoke(obj));
	}
	public static String initStr(String old){
		String newstr=old.substring(0,1).toUpperCase()+old.substring(1);
		return newstr;
	}

}
