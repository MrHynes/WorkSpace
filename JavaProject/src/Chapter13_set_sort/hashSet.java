package Chapter13_set_sort;

import java.util.HashSet;
import java.util.Set;

public class hashSet {
	//hashset重复元素，自定义student类中，同名同年龄的我们认为是相同的人。
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
		//查看结果发现，存在两个同名同年龄的。那么要如何将两个相同的去掉一个呢？
		//必须在student类中覆写equals 和hashCode方法
	}

}
