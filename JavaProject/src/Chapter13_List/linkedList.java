package Chapter13_List;

import java.util.LinkedList;
import java.util.List;

public class linkedList {
	public static void main(String[] args) {
		LinkedList<String> aLinkedList=new LinkedList<String>();
		aLinkedList.add("B");
		aLinkedList.add("C");
		aLinkedList.add("D");
		System.out.println(aLinkedList);
		aLinkedList.addFirst("A");
		aLinkedList.addLast("D");
		System.out.println(aLinkedList);
		//’“±ÌÕ∑
		System.out.println(aLinkedList.element());
		System.out.println(aLinkedList);
		//
		System.out.println(aLinkedList.peek());
		System.out.println(aLinkedList);
		//
		System.out.println(aLinkedList.poll());
		System.out.println(aLinkedList);
		
		
	}

}
