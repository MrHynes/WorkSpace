package Chapter01;

public class Search {
	//��������
	public int linearSearch(int a[],int x){
		int j=0;
		while(j<a.length-1&&x!=a[j]){//j<6
			j=j+1;
			
		}
		if(x==a[j]) return j;
		else return -1;
	}
	//��������
	public int binarySearch(int a[],int x){
		int low=0,high=a.length,mid;
		int k=-1;
		while(low<=high){
			mid=(low+high)/2;
			if(x==a[mid]){
				k=mid; 
				break;
			}
			else if(x>a[mid]) low=mid+1;
			else high=mid-1;
		}
		return k;
	}
}