package t01;
import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu1=new Student("张三", 19,98);
		Student stu2=new Student("李四", 24,86);
		Student stu3=new Student("王五", 21,95);
		List<Student> list=new ArrayList<Student>();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		//遍历
		Iterator<Student> it=list.iterator();
		while(it.hasNext()){
			System.out.println(it.next()+";");
		}
		//移除
		while(it.hasNext()){
			it.remove();
		}
		if(!it.hasNext()){
			System.out.println("元素已经移除");
		}
		
	}

}
