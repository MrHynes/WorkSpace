
import java.util.*;
public class fa_tongpei {
	/**
	 * @param args
	 * 无界泛型通配
	 */
	void show(List<?> list){
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+",");
		}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fa_tongpei test=new fa_tongpei();
		List<String> list=new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		test.show(list);
	}
}
