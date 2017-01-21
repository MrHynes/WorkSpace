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
		
		//�ж�key��value�Ƿ����
		System.out.println(hashMap.containsKey("1"));
		System.out.println(hashMap.containsKey("4"));
		System.out.println(hashMap.containsValue("ccc"));
		System.out.println(hashMap.containsValue("ddd"));
		
		
		//���ȫ����key��valueֵ
		System.out.println("���ȫ����key��valueֵ");
		Set allSet=hashMap.keySet();
		Iterator<String> it=allSet.iterator();
		while(it.hasNext()){
			String string=it.next();
			System.out.println(string+"-->"+hashMap.get(string));
		}
		
		//��׼���value��key
		System.out.println("ʹ��Iterator���map��value��key");
		Set<Map.Entry<String, String>> allset=hashMap.entrySet();
		Iterator<Map.Entry<String, String>> iterator=allset.iterator();
		while(iterator.hasNext()){
			Map.Entry<String, String> meEntry=iterator.next();
			System.out.println(meEntry.getKey()+"-->"+meEntry.getValue());
		}
		
		System.out.println("ʹ��foreach���map��value��key");
		//Set<Map.Entry<String, String>> allset2=hashMap.entrySet();
		for (Map.Entry<String, String> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey()+"-->"+entry.getValue());
		}
		
	}

}







