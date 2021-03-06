package pers.qiqcheng.exp01_01;

public class Sort {
	/*
	 * 快速排序
	 */
	public void QuickSort(int a[],int left,int right){
		if(left>right) return;
		int i,j,temp,t;
		i=left;
		j=right;
		temp=a[left];
		while(i!=j){
			while(i<j&&a[j]>=temp){
				j--;
			}
			while(i<j&&a[i]<=temp){
				i++;
			}
			if(i<j){
				t=a[i];
				a[i]=a[j];
				a[j]=t;
			}
		}
		a[left]=a[i];
		a[i]=temp;
		QuickSort(a, left, i-1);
		QuickSort(a, i+1, right);	
	}
}
