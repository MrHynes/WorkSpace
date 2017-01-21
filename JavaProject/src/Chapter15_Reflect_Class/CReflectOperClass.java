package Chapter15_Reflect_Class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.mysql.jdbc.StreamingNotifiable;
import com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor;

public class CReflectOperClass {
	public static void main(String[] args) throws Exception {
		// ��ȡClass������ַ���
		// m1
		Class class1 = int.class;
		System.out.println(class1.getName());
		// m2
		Object object = new Object();
		System.out.println(object.getClass().getName());
		// m3
		Class class2 = Class.forName("java.lang.String");
		System.out.println(class2.getName());

		// Classs���ʹ��
		// ͨ���޲ι��캯��ʵ��������
		Class cstudent = Class.forName("Chapter15_Reflect_Class.CStudent");
		CStudent stu = (CStudent) cstudent.newInstance();
		stu.setAge(12);
		stu.setName("cheng");
		System.out.println(stu.toString());
		// ʹ�÷���ȡ��CStudentʵ�ֵ�ȫ���ӿ�
		Class interf[] = cstudent.getInterfaces();
		System.out.println("CStudent��ʵ�ֵ����нӿ���:");
		for (int i = 0; i < interf.length; i++) {
			System.out.println("�ӿ�" + (i + 1) + ":" + interf[i].getName());
		}
		// ʹ�÷���ȡ�ø���
		Class superclass = cstudent.getSuperclass();
		System.out.println("CStudent��̳еĸ���:");
		System.out.println("����:" + superclass.getName());
		// ʹ�÷���ȡ��ȫ�����췽��
		Constructor[] con = cstudent.getConstructors();
		System.out.println("CStudent������й��췽����:");
		for (int i = 0; i < con.length; i++) {
			System.out.println("���췽��" + (i + 1) + ":" + con[i]);
		}
		// ʹ�÷���ȡ��ȫ������
		System.out.println("CStudent������з�����:");
		getMethod(cstudent);
		//ʹ�÷���ȡ����������
		System.out.println("CStudent�������������:");
		//ȡ�ñ��������
		Field []fields=cstudent.getDeclaredFields();
		getField(fields);
		//ȡ�ø��๫������
		Field []superFieds=cstudent.getFields();
		getField(superFieds);
	}

	public static void getMethod(Class cstudent) {
		// ʹ�÷���ȡ��ȫ������
		Method[] method = cstudent.getMethods();
		/*
		 * for(int i=0;i<method.length;i++){
		 * System.out.println("����"+(i+1)+":"+method[i]); }
		 */
		for (int i = 0; i < method.length; i++) {
			// ȡ�÷���ֵ����
			Class returnType = method[i].getReturnType();
			// ȡ�����в�������
			Class arg[] = method[i].getParameterTypes();
			// ȡ�÷������η�
			int mod = method[i].getModifiers();
			String fw = Modifier.toString(mod);
			// ȡ�÷�������
			String methodName = method[i].getName();
			// �������
			System.out.print("����" + (i + 1) + ":" + fw + " " + returnType.getName() + " " + methodName + "(");
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
			//ȡ�����Ե�����
			Class type=fields[i].getType();
			//ȡ�����η�
			int mod=fields[i].getModifiers();
			String xs=Modifier.toString(mod);
			//ȡ����������
			String fieleName=fields[i].getName();
			System.out.println("����"+(i+1)+":"+xs+" "+type+" "+fieleName+";");
		}
	}
}
