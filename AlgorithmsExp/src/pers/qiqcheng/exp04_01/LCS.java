package pers.qiqcheng.exp04_01;

import java.util.Scanner;

import pers.qiqcheng.exp01_01.Sort;

/*
 * 最长共子序列问题，课本p130
 */
public class LCS {
	private static final int MAXSIZE=100;
	
	/**
	 * 判断a和b哪个大
	 * a,b
	 */
	/*public static int max(int a,int b){
		if(a>b) return a;
		else return b;
	}
	*/	
	/**
	 * 求最长公共子序列
	 * @param H 
	 * @param n 数组a的长度
	 * @param m 数组b的长度
	 * @param L 数组L[i][j]表示ai bj的最长公共子序列的长度
	 * @param a 数组a
	 */
	public static void printLcs(int H[][],int n,int m,int L,int a[]){
		int c[]=new int[L];
		int i=n;
		int j=m;
		int l=0;
		while(i>0&&j>0){
			if(H[i][j]==0){
				//插入c中
				c[l]=a[i];
				l++;
				i--;
				j--;
			}else {
				if(H[i][j]==1){
					i--;
				}else {
					j--;
				}
			}
		}
		//倒序输出
		for(int k=L-1;k>=0;k--){
			System.out.print(c[k]+" ");
		}
	}
	/**
	 * 求a和b最长公共子序列的长度
	 * @param a 数组a
	 * @param b 数组b
	 * @param m 数组a的长度
	 * @param k 数组b的长度
	 */
	public static void  Lcs(int a[],int b[],int m,int k){
		int L[][]=new int[m+1][k+1];//L[m][k],表示a[0..m]与b[0...k]的最长公共子序列长度
		int H[][]=new int[m+1][k+1];//序列A和B的最长公共子序列的有关信息数组H[1..n, 1..m]
		//先将L[O][J] L[I][0]置0
		for(int j=0;j<m;j++){
			L[0][j]=0;
		}
		for(int i=0;i<k;i++){
			L[i][0]=0;
		}
		//
		for(int i=1;i<=m;i++){
			for(int j=1;j<=k;j++){
				if(a[i]==b[j]){//如果a[i]=b[j],那么L[i][j]=L[i-1][j-1]+1;
					L[i][j]=L[i-1][j-1]+1;
					H[i][j]=0;
				}/*else{
					L[i][j]=max(L[i][j-1],L[i-1][j]);
				}*/
				//否则L[i][j]=max(L[i][j-1],L[i-1][j]);
				else if(L[i-1][j]>=L[i][j-1]){
					L[i][j]=L[i-1][j];
					H[i][j]=1;
				}else {
					L[i][j]=L[i][j-1];
					H[i][j]=2;
				}
			}
		}
		//L[m][k]即为最长公共子序列的长度
		System.out.println(L[m][k]);
		//求最长公共子序列
		printLcs(H,m,k,L[m][k],a);
		//return L[m][k];
	}
	public static void main(String[] args) {
		int n;//测试数据例个数
		int m,k;//序列长度
		int a[]=new int[MAXSIZE];//序列A
		int b[]=new int[MAXSIZE];//序列B
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();
		while(n>0){
			m=scanner.nextInt();
			//循环读入数组a中的数据
			for(int i=1;i<=m;i++){
				a[i]=scanner.nextInt();
			}
			//循环读入数组b中的数据
			k=scanner.nextInt();
			for(int i=1;i<=k;i++){
				b[i]=scanner.nextInt();
			}
			//将ab数组升序排序
			Sort sort=new Sort();
			sort.QuickSort(a, 1, m);
			sort.QuickSort(b, 1, k);
			n--;	
			/*for(int i=0;i<=m;i++){
				System.out.print(a[i]+" ");
			}
			for(int i=0;i<=k;i++){
				System.out.print(b[i]+" ");
			}*/
			//求最长公共子序列
			Lcs(a, b, m, k);
		}
		
	}

}
