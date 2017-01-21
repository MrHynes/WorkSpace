package laerningJava.chapter01;

import java.util.*;
public class testHashMap {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Student> hashMap=new HashMap<String,Student>();
		hashMap.put("1",new Student("张三", 18));
		hashMap.put("2",new Student("李四", 19));
		hashMap.put("3",new Student("王五", 20));
		Student stu=hashMap.get("1");
		System.out.println("姓名："+stu.getName()+"  年龄："+stu.getAge());
		Iterator<String> it=hashMap.keySet().iterator();
		while(it.hasNext()){
		String str=it.next();
		Student student=hashMap.get(str);
		System.out.println("姓名："+student.getName()+"  年龄："+student.getAge());
		}
	}

}
