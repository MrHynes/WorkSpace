package Chapter03;

public class DataDem02 {
	public static void main(String[] args) {
		
		int max=Integer.MAX_VALUE;
		System.out.println(max);
		//溢出
		System.out.println("max+1="+(max+1));
		System.out.println("max+2="+(max+2));
		//强制类型转换防止溢出
		System.out.println("max+1="+((long)max+1));
		System.out.println("max+1="+(max+1L));
	}

}
