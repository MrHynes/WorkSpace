package pers.qiqcheng.exp03_02;

import java.util.Scanner;

import pers.qiqcheng.exp01_01.Sort;

public class Select {
	public static void main(String[] args) {
		int n, m, k;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		while (n > 0) {
			m = scanner.nextInt();
			int arr[] = new int[m];
			for (int i = 0; i < m; i++) {
				arr[i] = scanner.nextInt();
			}
			k = scanner.nextInt();
			for(int j=1;j<=k;j++){
				System.out.print(select(arr, 0, m - 1, j)+" ");
			}
			n--;
		}
	}

	private static int select(int[] arr, int low, int high, int k) {
		int q;
		Sort sort=new Sort();
		int p = high - low + 1;// 子数组规模
		if (p < 12) {//44
			sort.QuickSort(arr, low, high);
			return arr[k-1];
		}else{
			q=(int) Math.floor(p/5);//arr分成q组
			int M[]=new int[q];
			//System.out.println("q="+q);
			for(int i=1;i<=q;i++){
				sort.QuickSort(arr, (i-1)*5, 5*i-1);//arr分成q组，每组各自排序
				M[i-1]=arr[i*5-3];//各组中项的集合
			}
			int mm=select(M, 0, q-1,(int)Math.rint(q-1/2));//中项集合的主元 46
			int lm=0,em=0,gm=0;
			int A1[]=new int[20];
			int A2[]=new int[20];
			int A3[]=new int[20];
			for(int i=0;i<=high;i++){
				if(arr[i]==mm) A2[em++]=arr[i];
				else if(arr[i]<=mm) A1[lm++]=arr[i];
				else A3[gm++]=arr[i];
			}
			if(k<=lm) return select(A1, 0, lm-1, k);
			else if(k<=(lm+em))  return mm;
			else  return select(A3, 0, gm-1, k-lm-em);
		}
	}
}
