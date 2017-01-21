package Chapter13_Set;

import java.util.HashSet;
import java.util.Set;

public class hashset {
	public static void main(String[] args) {
		Set<String> hashSet=new HashSet<String>();
		hashSet.add("A");
		hashSet.add("D");
		hashSet.add("D");
		hashSet.add("C");
		hashSet.add("B");
		System.out.println(hashSet);
	}

}
