package Chapter13_Map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CTreeMap {
	public static void main(String[] args) {
		TreeMap<String, String> treeMap=new TreeMap<String, String>();
		treeMap.put("1", "aaa");
		treeMap.put("3", "ccc");
		treeMap.put("2", "bbb");
		System.out.println(treeMap);
		
		//Êä³ökeyºÍvalue
		Set<String> allSet=treeMap.keySet();
		Iterator<String> it=allSet.iterator();
		while(it.hasNext()){
			String string=it.next();
			System.out.println(string+"-->"+treeMap.get(string));
		}
	}

}
