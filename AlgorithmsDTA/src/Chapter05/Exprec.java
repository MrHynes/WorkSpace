package Chapter05;

public class Exprec {
	/**
	 * ��x��n�η�
	 */
	public int getPower(int x,int n){
		int y=0;
		if(n==0) y=1;
		else{
			y=getPower(x, (int)(n/2));
			y=y*y;
			if(n%2==1){
				y=y*x;
			}
		}
		return y;
	}
}
