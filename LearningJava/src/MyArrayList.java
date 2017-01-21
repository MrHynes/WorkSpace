import java.util.*;
public class MyArrayList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> arraylist=new ArrayList<String>();//·ºÐÍ
		arraylist.add("red");
		arraylist.add("green");
		arraylist.add("blue");
		String []values=new String[arraylist.size()];
		arraylist.toArray(values);
		for(int i=0;i<values.length;i++){
			System.out.println(values[i].toString());
			
		}
	}
}
