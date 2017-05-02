package pers.qiqcheng.exp04_01;

import java.util.Scanner;

import pers.qiqcheng.exp01_01.Sort;

/*
 * ������������⣬�α�p130
 */
public class LCS {
	private static final int MAXSIZE=100;
	
	/**
	 * �ж�a��b�ĸ���
	 * a,b
	 */
	/*public static int max(int a,int b){
		if(a>b) return a;
		else return b;
	}
	*/	
	/**
	 * �������������
	 * @param H 
	 * @param n ����a�ĳ���
	 * @param m ����b�ĳ���
	 * @param L ����L[i][j]��ʾai bj������������еĳ���
	 * @param a ����a
	 */
	public static void printLcs(int H[][],int n,int m,int L,int a[]){
		int c[]=new int[L];
		int i=n;
		int j=m;
		int l=0;
		while(i>0&&j>0){
			if(H[i][j]==0){
				//����c��
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
		//�������
		for(int k=L-1;k>=0;k--){
			System.out.print(c[k]+" ");
		}
	}
	/**
	 * ��a��b����������еĳ���
	 * @param a ����a
	 * @param b ����b
	 * @param m ����a�ĳ���
	 * @param k ����b�ĳ���
	 */
	public static void  Lcs(int a[],int b[],int m,int k){
		int L[][]=new int[m+1][k+1];//L[m][k],��ʾa[0..m]��b[0...k]������������г���
		int H[][]=new int[m+1][k+1];//����A��B������������е��й���Ϣ����H[1..n, 1..m]
		//�Ƚ�L[O][J] L[I][0]��0
		for(int j=0;j<m;j++){
			L[0][j]=0;
		}
		for(int i=0;i<k;i++){
			L[i][0]=0;
		}
		//
		for(int i=1;i<=m;i++){
			for(int j=1;j<=k;j++){
				if(a[i]==b[j]){//���a[i]=b[j],��ôL[i][j]=L[i-1][j-1]+1;
					L[i][j]=L[i-1][j-1]+1;
					H[i][j]=0;
				}/*else{
					L[i][j]=max(L[i][j-1],L[i-1][j]);
				}*/
				//����L[i][j]=max(L[i][j-1],L[i-1][j]);
				else if(L[i-1][j]>=L[i][j-1]){
					L[i][j]=L[i-1][j];
					H[i][j]=1;
				}else {
					L[i][j]=L[i][j-1];
					H[i][j]=2;
				}
			}
		}
		//L[m][k]��Ϊ����������еĳ���
		System.out.println(L[m][k]);
		//�������������
		printLcs(H,m,k,L[m][k],a);
		//return L[m][k];
	}
	public static void main(String[] args) {
		int n;//��������������
		int m,k;//���г���
		int a[]=new int[MAXSIZE];//����A
		int b[]=new int[MAXSIZE];//����B
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();
		while(n>0){
			m=scanner.nextInt();
			//ѭ����������a�е�����
			for(int i=1;i<=m;i++){
				a[i]=scanner.nextInt();
			}
			//ѭ����������b�е�����
			k=scanner.nextInt();
			for(int i=1;i<=k;i++){
				b[i]=scanner.nextInt();
			}
			//��ab������������
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
			//�������������
			Lcs(a, b, m, k);
		}
		
	}

}