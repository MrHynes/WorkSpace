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
	/**
	 * 合并两个有序数组A[p..q] A[p+1..r]
	 * @param a
	 */
	public void Merge(int a[],int low,int mid,int high){
		int b[]=new int[a.length];
		int s=low,t=mid+1,k=low;
		while(s<=mid&&t<=high){
			if(a[s]<=a[t]){
				b[k]=a[s];
				s++;
			}else {
				b[k]=a[t];
				t++;
			}
			k++;
		}
		if(s==mid+1){
			for(int i=t;i<a.length;i++){
				b[k]=a[i];
				k++;
			}
		}else {
			for(int i=s;i<mid+1;i++){
				b[k]=a[i];
				k++;
			}
		}
		for(int i=low;i<=high;i++)
			a[i]=b[i];
	}
	//选择排序
	public void selectionSort(int a[]){
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
	}
	//插入排序5,3,1,7
	public void insertionSort(int a[]){
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
	}
	
	/*
	 * 冒泡排序
	 */
	public void bubbleSort(int a[]){
		int temp;
		for(int i=1;i<a.length;i++){//总共需要给n-1个元素排序
			for(int j=0;j<a.length-i;j++){//比较次数是a.length-i
				if(a[j]>a[j+1]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}
	/**
	 * 快速排序
	 */
	public void quickSort(int a[],int left,int right){
		if(left>right) return;
		int i=left,j=right;
		int temp=a[left];
		int t;
		/**
		 * //哨兵j在右边，哨兵i在左边，j先向前走，若找到一个小于a[left]的元素就，停止
		 * 然后哨兵i向右走，如果找到一个大于a[left]的元素，就停止，然后互换a[i] a[j].
		 * 直到i和j相遇，将相遇的元素和a[left]互换。
		 */
		while(i!=j){			
			while(i<j&&a[j]>=temp)
				j--;
			while(i<j&&a[i]<=temp)
				i++;
			if(i<j){
				t=a[i];
				a[i]=a[j];
				a[j]=t;
			}
		}
		a[left]=a[i];
		a[i]=temp;
		quickSort(a, left, i-1);
		quickSort(a, i+1, right);
	}
	/**
	 * 自底向上合并排序
	 */
	public void bottomupSort(int a[]){
		int t=1;
		int s,i;
		while(t<a.length-1){
			s=t;
			t=s*2;
			i=0;
			while(i+t<=a.length-1){
				Merge(a, i, i+s-1, i+t-1);
				i=i+t;
			}
			if(i+s<a.length-1)
				Merge(a, i, i+s-1, a.length-1);
		}
	}
	/**
	 * 自顶向下合并排序
	 */
	public void mergeSort(int a[],int low,int high){
		int mid;
		if(low<high){
			mid=(low+high)/2;
			mergeSort(a, low, mid);
			mergeSort(a, mid+1, high);
			Merge(a, low, mid, high);
		}
	}
}
