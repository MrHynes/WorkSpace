package Chapter05;

public class Candidate {
	public int candidate(int a[],int m){
		int j=m;
		int c=a[j];
		int count=1;
		while(count>0&&j<a.length-1){
			j=j+1;
			if(a[j]==c){
				count++;
			}else {
				count--;
			}
		}
		if(j==a.length-1) return c;
		else {
			return candidate(a, j+1);
		}
	}

}
