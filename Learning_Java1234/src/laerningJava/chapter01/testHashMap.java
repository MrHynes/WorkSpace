package laerningJava.chapter01;

import java.util.*;
public class testHashMap {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Student> hashMap=new HashMap<String,Student>();
		hashMap.put("1",new Student("����", 18));
		hashMap.put("2",new Student("����", 19));
		hashMap.put("3",new Student("����", 20));
		Student stu=hashMap.get("1");
		System.out.println("������"+stu.getName()+"  ���䣺"+stu.getAge());
		Iterator<String> it=hashMap.keySet().iterator();
		while(it.hasNext()){
		String str=it.next();
		Student student=hashMap.get(str);
		System.out.println("������"+student.getName()+"  ���䣺"+student.getAge());
		}
	}

}
