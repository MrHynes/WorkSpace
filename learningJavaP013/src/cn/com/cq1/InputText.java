package cn.com.cq1;
import java.util.*;
public class InputText{
	public static void main(String[] args) {
		int a[]={1,2,5,4};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		Arrays.fill(a, 100);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.binarySearch(a, 100));
	
	}
}