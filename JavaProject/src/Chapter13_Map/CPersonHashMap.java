package Chapter13_Map;

import java.util.HashMap;
import java.util.HashSet;

import Chapter06.main;

public class CPersonHashMap {
	public static void main(String[] args) {
		HashMap<Person, String> hashMap=new HashMap<Person, String>();
		Person person=new Person("cheng", 14);
		//Ҫͨ�����������ҵ����ڵ�value�����б���ʵ��hashCode()��equals()����
		hashMap.put(new Person("li", 16), "li16");
		hashMap.put(person, "cheng14");
		System.out.println(hashMap.get(new Person("li", 16)));
		System.out.println(hashMap.get(person));
	}

}
