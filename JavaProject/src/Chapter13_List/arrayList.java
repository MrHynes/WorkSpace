package Chapter13_List;

import java.util.ArrayList;
import java.util.List;

public class arrayList {
	public static void main(String[] args) {
		List<String> allList=new ArrayList<String>();
		allList.add("world1");
		allList.add(0,"hello");
		allList.add("world2");
		allList.add("world3");
		allList.add("!!");
		System.out.println(allList);
		allList.remove("!!");
		allList.remove(0);
		System.out.println(allList);
		//前向后输出所有元素
		for(int i=0;i<allList.size();i++){
			System.out.print(allList.get(i)+" ");
		}
		//后向前输出所有元素
		System.out.println();
		for(int j=allList.size()-1;j>=0;j--){
			System.out.print(allList.get(j)+" ");
		}
		System.out.println();
		//将集合变为对象数组
		String str[]=allList.toArray(new String[]{});
		for(int i=0;i<str.length;i++){
			System.out.print(str[i]+" ");
		}
		//是否包含字符串world2
		System.out.println(allList.contains("world2"));
		//world1字符串的位置
		System.out.println(allList.indexOf("world1"));
		//判断集合是否为空
		System.out.println(allList.isEmpty());
	}

}
