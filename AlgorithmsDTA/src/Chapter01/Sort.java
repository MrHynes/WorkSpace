package Chapter01;

public class Sort {
	//合并两个有序数组
	public int[] Merge(int a[],int b[]){
		int i=0,j=0,k=0;
		int c[]=new int[a.length+b.length];
		while(i<a.length&&j<b.length){
			if(a[i]<b[j]){
				c[k]=a[i];
				i++;
				k++;
			}
			else{
				c[k]=b[j];
				k++;
				j++;
			}
		}
		//将剩下的全部插入到数组c中
		if(i==a.length){
			for(;j<b.length;j++){
				c[k]=b[j];
				k++;
			}
		}else{
			for(;i<a.length;i++){
				c[k]=a[i];
				k++;
			}
		}
		return c;
	}
	//选择排序
	public int[] selectionSort(int a[]){
		int k,temp,i;
		for(i=0;i<a.length-1;i++){
			k=i;
			for(int j=i+1;j<a.length;j++){//选出最小的元素
				if(a[k]>a[j]) k=j;//k是最小元素的下标
			}
			if(k!=i){//最小元素和最前面的元素交换
				temp=a[i];
				a[i]=a[k];
				a[k]=temp;
			}
		}
		return a;
	}
	//插入排序5,3，1,7
	public int[] insertionSort(int a[]){
		int x,j;
		for(int i=1;i<a.length;i++){
			x=a[i];
			j=i-1;
			while(j>=0&&a[j]>x){
				a[j+1]=a[j];
				j=j-1;
			}
			a[j+1]=x;
		}
		return a;
	}
	
}
