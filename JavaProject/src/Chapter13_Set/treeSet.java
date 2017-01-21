package Chapter13_Set;

import java.util.Set;
import java.util.TreeSet;

public class treeSet {
	public static void main(String[] args) {
		//ÓÐÐòµÄ´æ·Å
		Set<String> treeSet=new TreeSet<String>();
		treeSet.add("d");
		treeSet.add("a");
		treeSet.add("c");
		treeSet.add("b");
		System.out.println(treeSet);
	}

}
