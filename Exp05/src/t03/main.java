package t03;
import java.util.*;
public class main {
	public static void main(String[] args) {
		Student stu1=new Student("张三", 19,98);
		Student stu2=new Student("李四", 24,86);
		Student stu3=new Student("王五", 21,95);
		Set<Student> treeSet=new TreeSet<Student>();
		treeSet.add(stu1);
		treeSet.add(stu2);
		treeSet.add(stu3);
		System.out.println(treeSet);
		
	}
}
