package Chapter05.execise;

public class Average5_4 {

	public static float Average(int a[],int n){
		if(n==1)
			return a[0];
		else {
			return (float)(Average(a, n-1)*(n-1)+a[n-1])/n;
		}
	}
	public static void main(String[] args) {
		int a[]={1,2,50,98,99};
		System.out.println(Average(a, 5));
	}
}
