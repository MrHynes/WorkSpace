package pers.qiqcheng.exp01_02;

import java.util.Scanner;

import pers.qiqcheng.exp01_01.Sort;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int m;
		for(int i=0;i<n;i++){
			m=scanner.nextInt();
			int a[]=new int[m];
			for(int j=0;j<m;j++){
				a[j]=scanner.nextInt();
			}
			new Sort().QuickSort(a, 0, a.length-1);
			for(int k=0;k<a.length;k++){
				if(k==a.length/2)
					System.out.println();
				System.out.print(a[k]+" ");
			}
		}
	}
}
