package Chapter05;

public class Horner {

	public int GetValues(int x,int n,int a[]){
		int len=a.length;
		int p=a[len-1];
		while(n>1){
			p=p*x+a[n-1];
			n=n-1;
		}
		return p;
	}
}
