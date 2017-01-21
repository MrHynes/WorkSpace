package Chapter04_Array;

public class Digui {
//ตÝน้
	public static int sum(int x){
		if(x==1)
			return 1;
		else
			return x+sum(x-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum(10));
		

	}

}
