package t01;
import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu1=new Student("����", 19,98);
		Student stu2=new Student("����", 24,86);
		Student stu3=new Student("����", 21,95);
		List<Student> list=new ArrayList<Student>();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		//����
		Iterator<Student> it=list.iterator();
		while(it.hasNext()){
			System.out.println(it.next()+";");
		}
		//�Ƴ�
		while(it.hasNext()){
			it.remove();
		}
		if(!it.hasNext()){
			System.out.println("Ԫ���Ѿ��Ƴ�");
		}
		
	}

}
