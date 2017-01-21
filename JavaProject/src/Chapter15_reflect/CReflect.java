package Chapter15_reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CReflect {
	public static void main(String[] args) throws Exception {
		Class c=null;
		c=Class.forName("Chapter15_reflect.CPerson");
		System.out.println("获取CPerson的所有属性");
		Field field[]=c.getDeclaredFields();
		for(int i=0;i<field.length;i++){
			Class r=field[i].getType();//取得属性类型
			int m=field[i].getModifiers();//取得修饰符数字
			String pri=Modifier.toString(m);//取得修饰符
			System.out.println(pri+" "+r.getName()+" "+field[i].getName());
		}
		System.out.println("获取CPerson的所有方法");
		Method method[]=c.getMethods();
		for(int i=0;i<method.length;i++){
			//返回值类型
			Class returnType=method[i].getReturnType();
			//修饰符
			int x=method[i].getModifiers();
			String mod=Modifier.toString(x);
			//方法名
			String methods=method[i].getName();
			//获取参数类型
			Class p[]=method[i].getParameterTypes();
			System.out.print(mod+" "+returnType.getName()+" "+methods+"(");
			for(int j=0;j<p.length;j++){
				System.out.print(p[j].getName()+" arg"+j);
				if(j<p.length-1)
					System.out.print(",");
				System.out.print(")");
			}
			System.out.println(")");
		}
		
	}
}
