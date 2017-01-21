import java.util.*;
public class fx_tongpei_down {
	/**
	 * @param args
	 * 泛型下限通配super
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<? super Number> demo=new ArrayList<Number>();
		demo.add(1);
		demo.add(2);
		System.out.print(demo);
	}
}
