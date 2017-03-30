package pers.qiqcheng.exp01_01;

import java.util.Scanner;

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
			if(isEqual(a)){
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	
	/**
	 * �ж�����Ԫ���Ƿ���ͬ
	 * @param a
	 * @return
	 */
	public static boolean isEqual(int a[]){
		boolean flag=false;
		for(int i=0;i<a.length-1;i++){
			if(a[i+1]==a[i]){
				flag=true;
			}
		}
		return flag;
	}
}