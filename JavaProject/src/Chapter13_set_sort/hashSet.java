package Chapter13_set_sort;

import java.util.HashSet;
import java.util.Set;

public class hashSet {
	//hashset�ظ�Ԫ�أ��Զ���student���У�ͬ��ͬ�����������Ϊ����ͬ���ˡ�
	public static void main(String[] args) {
		student stu1=new student("mm", 16);
		student stu2=new student("mm", 16);
		student stu3=new student("kk", 17);
		student stu4=new student("kk", 17);
		Set<student> hashset=new HashSet<student>();
		hashset.add(stu1);
		hashset.add(stu2);
		hashset.add(stu3);
		hashset.add(stu4);
		System.out.println(hashset);
		//�鿴������֣���������ͬ��ͬ����ġ���ôҪ��ν�������ͬ��ȥ��һ���أ�
		//������student���и�дequals ��hashCode����
	}

}
