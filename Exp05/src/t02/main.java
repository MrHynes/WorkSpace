package t02;
import java.util.*;
public class main {
	public static void main(String[] args) {
		Student stu1=new Student("张三", 19,98);
		Student stu2=new Student("李四", 24,86);
		Student stu3=new Student("王五", 21,95);
		Set <Student> hashSet=new HashSet<Student>();
		hashSet.add(stu1);
		hashSet.add(stu2);
		hashSet.add(stu3);
		System.out.println(hashSet);
		LinkedHashSet<Student> linkedHashSet=new LinkedHashSet<Student>();
		linkedHashSet.add(stu1);
		linkedHashSet.add(stu2);
		linkedHashSet.add(stu3);
		System.out.println(linkedHashSet);
	}
}
