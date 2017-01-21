package Chapter15_reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CReflect {
	public static void main(String[] args) throws Exception {
		Class c=null;
		c=Class.forName("Chapter15_reflect.CPerson");
		System.out.println("��ȡCPerson����������");
		Field field[]=c.getDeclaredFields();
		for(int i=0;i<field.length;i++){
			Class r=field[i].getType();//ȡ����������
			int m=field[i].getModifiers();//ȡ�����η�����
			String pri=Modifier.toString(m);//ȡ�����η�
			System.out.println(pri+" "+r.getName()+" "+field[i].getName());
		}
		System.out.println("��ȡCPerson�����з���");
		Method method[]=c.getMethods();
		for(int i=0;i<method.length;i++){
			//����ֵ����
			Class returnType=method[i].getReturnType();
			//���η�
			int x=method[i].getModifiers();
			String mod=Modifier.toString(x);
			//������
			String methods=method[i].getName();
			//��ȡ��������
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
