package Chapter15_Reflect_Class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.mysql.jdbc.StreamingNotifiable;
import com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor;

public class CReflectOperClass {
	public static void main(String[] args) throws Exception {
		// 获取Class类的三种方法
		// m1
		Class class1 = int.class;
		System.out.println(class1.getName());
		// m2
		Object object = new Object();
		System.out.println(object.getClass().getName());
		// m3
		Class class2 = Class.forName("java.lang.String");
		System.out.println(class2.getName());

		// Classs类的使用
		// 通过无参构造函数实例化对象
		Class cstudent = Class.forName("Chapter15_Reflect_Class.CStudent");
		CStudent stu = (CStudent) cstudent.newInstance();
		stu.setAge(12);
		stu.setName("cheng");
		System.out.println(stu.toString());
		// 使用反射取得CStudent实现的全部接口
		Class interf[] = cstudent.getInterfaces();
		System.out.println("CStudent类实现的所有接口有:");
		for (int i = 0; i < interf.length; i++) {
			System.out.println("接口" + (i + 1) + ":" + interf[i].getName());
		}
		// 使用反射取得父类
		Class superclass = cstudent.getSuperclass();
		System.out.println("CStudent类继承的父类:");
		System.out.println("父类:" + superclass.getName());
		// 使用反射取得全部构造方法
		Constructor[] con = cstudent.getConstructors();
		System.out.println("CStudent类的所有构造方法有:");
		for (int i = 0; i < con.length; i++) {
			System.out.println("构造方法" + (i + 1) + ":" + con[i]);
		}
		// 使用反射取得全部方法
		System.out.println("CStudent类的所有方法有:");
		getMethod(cstudent);
		//使用反射取得所有属性
		System.out.println("CStudent类的所有属性有:");
		//取得本类的属性
		Field []fields=cstudent.getDeclaredFields();
		getField(fields);
		//取得父类公共属性
		Field []superFieds=cstudent.getFields();
		getField(superFieds);
	}

	public static void getMethod(Class cstudent) {
		// 使用反射取得全部方法
		Method[] method = cstudent.getMethods();
		/*
		 * for(int i=0;i<method.length;i++){
		 * System.out.println("方法"+(i+1)+":"+method[i]); }
		 */
		for (int i = 0; i < method.length; i++) {
			// 取得返回值类型
			Class returnType = method[i].getReturnType();
			// 取得所有参数类型
			Class arg[] = method[i].getParameterTypes();
			// 取得访问修饰符
			int mod = method[i].getModifiers();
			String fw = Modifier.toString(mod);
			// 取得方法名称
			String methodName = method[i].getName();
			// 输出方法
			System.out.print("方法" + (i + 1) + ":" + fw + " " + returnType.getName() + " " + methodName + "(");
			for (int j = 0; j < arg.length; j++) {
				System.out.print(arg[j].getName() + " " + "arg" + j);
				if (j < arg.length - 1) {
					System.out.print(",");
				}
			}
			Class[] exception = method[i].getExceptionTypes();
			if (exception.length > 0) {
				System.out.print(")throws");
			} else {
				System.out.print(")");
			}
			for (int k = 0; k < exception.length; k++) {
				System.out.print(exception[k].getName());
				if (k < exception.length - 1) {
					System.out.print(",");
				}
			}
			System.out.println();
		}
	}

	public static void getField(Field[] fields){
		
		for(int i=0;i<fields.length;i++){
			//取得属性的类型
			Class type=fields[i].getType();
			//取得修饰符
			int mod=fields[i].getModifiers();
			String xs=Modifier.toString(mod);
			//取得属性名称
			String fieleName=fields[i].getName();
			System.out.println("属性"+(i+1)+":"+xs+" "+type+" "+fieleName+";");
		}
	}
}
