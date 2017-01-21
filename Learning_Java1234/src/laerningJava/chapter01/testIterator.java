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
		list.add(new Student("����",18));
		list.add(new Student("����",19));
		list.add(new Student("����",20));
		//���õ�����iterator ����Ԫ��
		System.out.println("���õ�����iterator ����Ԫ��:");
		Iterator<Student> it=list.iterator();
		while(it.hasNext()){
			Student stu=it.next();
			System.out.println("������"+stu.getName()+" ���䣺"+stu.getAge());
		}
		//����foreach����
		System.out.println("����foreach������Ԫ�أ�");
		for(Student stu:list){
			System.out.println("������"+stu.getName()+"  ���䣺"+stu.getAge());
		}
	}
}
