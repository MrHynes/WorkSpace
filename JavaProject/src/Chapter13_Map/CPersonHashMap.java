package Chapter13_Map;

import java.util.HashMap;
import java.util.HashSet;

import Chapter06.main;

public class CPersonHashMap {
	public static void main(String[] args) {
		HashMap<Person, String> hashMap=new HashMap<Person, String>();
		Person person=new Person("cheng", 14);
		//要通过匿名对象找到对于的value，类中必须实现hashCode()和equals()方法
		hashMap.put(new Person("li", 16), "li16");
		hashMap.put(person, "cheng14");
		System.out.println(hashMap.get(new Person("li", 16)));
		System.out.println(hashMap.get(person));
	}

}
