package Chapter13_set_sort;

import java.util.Set;
import java.util.TreeSet;

public class main {
	public static void main(String[] args) {
		student stu1=new student("mm", 16);
		student stu2=new student("ll", 15);
		student stu3=new student("kk", 17);
		Set<student> allSet=new TreeSet<student>();
		allSet.add(stu1);
		allSet.add(stu2);
		allSet.add(stu3);
		//自定义类排序，该类必须要实现Comparable接口
		System.out.println(allSet);
		//还有一种方法是创建比较器类comp
		Set<student> allSet2=new TreeSet<student>(new comp());
		allSet2.add(stu1);
		allSet2.add(stu2);
		allSet2.add(stu3);
		System.out.println(allSet2);
	}

}
