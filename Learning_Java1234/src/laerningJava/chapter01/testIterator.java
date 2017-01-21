package laerningJava.chapter01;
import java.util.*;
class Student{
	String name;
	int age;
	public Student(String name,int age) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
public class testIterator {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Student> list=new LinkedList<Student>();
		list.add(new Student("张三",18));
		list.add(new Student("李四",19));
		list.add(new Student("王五",20));
		//利用迭代器iterator 遍历元素
		System.out.println("利用迭代器iterator 遍历元素:");
		Iterator<Student> it=list.iterator();
		while(it.hasNext()){
			Student stu=it.next();
			System.out.println("姓名："+stu.getName()+" 年龄："+stu.getAge());
		}
		//利用foreach遍历
		System.out.println("利用foreach语句遍历元素：");
		for(Student stu:list){
			System.out.println("姓名："+stu.getName()+"  年龄："+stu.getAge());
		}
	}
}
