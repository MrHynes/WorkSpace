package Chapter13_Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CHashMap {
	public static void main(String[] args) {
		HashMap<String, String> hashMap=new HashMap<String, String>();
		hashMap.put("2", "bbb");
		hashMap.put("3", "ccc");
		hashMap.put("1", "aaa");
		System.out.println(hashMap);
		System.out.println(hashMap.get("2"));
		
		//判断key和value是否存在
		System.out.println(hashMap.containsKey("1"));
		System.out.println(hashMap.containsKey("4"));
		System.out.println(hashMap.containsValue("ccc"));
		System.out.println(hashMap.containsValue("ddd"));
		
		
		//输出全部的key和value值
		System.out.println("输出全部的key和value值");
		Set allSet=hashMap.keySet();
		Iterator<String> it=allSet.iterator();
		while(it.hasNext()){
			String string=it.next();
			System.out.println(string+"-->"+hashMap.get(string));
		}
		
		//标准输出value和key
		System.out.println("使用Iterator输出map的value和key");
		Set<Map.Entry<String, String>> allset=hashMap.entrySet();
		Iterator<Map.Entry<String, String>> iterator=allset.iterator();
		while(iterator.hasNext()){
			Map.Entry<String, String> meEntry=iterator.next();
			System.out.println(meEntry.getKey()+"-->"+meEntry.getValue());
		}
		
		System.out.println("使用foreach输出map的value和key");
		//Set<Map.Entry<String, String>> allset2=hashMap.entrySet();
		for (Map.Entry<String, String> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey()+"-->"+entry.getValue());
		}
		
	}

}







