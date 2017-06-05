package pers.qiqcheng.exp04_01;

import java.util.ArrayList;
import java.util.Scanner;
///http://www.cnblogs.com/coffy/p/5878915.html
public class MSIA {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int N = scan.nextInt();
			int[] num = new int[N];
			for (int j = 0; j < N; j++) {
				num[j] = scan.nextInt();
			}
			ArrayList list=maxSubIncreaseArray(num, N);
			for(int k=0;k<list.size();k++){
				System.out.print(list.get(k)+" ");
			}
			
		}
	}

	public static ArrayList<Integer> maxSubIncreaseArray(int[] array, int n) {
		int[] list = new int[n];
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		int index = -1;// 用于标记当前元素之前的第一个递增子序列的位置
		int maxIndex = 0;// 用于标记该序列的最长递增子序列的位置
		int max = Integer.MIN_VALUE;// 最长递增子序列的长度
		list[0] = 1;// 该列表用于标记包括当前元素在内的前半部分的最长递增子序列的长度
		tmp.add(array[0]);
		res.add(tmp);
		for (int i = 1; i < n; i++) {
			index = -1;
			tmp = new ArrayList<Integer>();//存储递增子序列
			for (int j = 0; j < i; j++) {
				if (array[j] < array[i] && list[j] > list[i]) {
					list[i] = list[j];
					index = j;//当前元素之前最长的递增子序列的位置
				}
			}
			++list[i];
			if (index > -1)
				tmp.addAll(res.get(index));//当前元素之前的最长递增子序列的元素
			tmp.add(array[i]);//加上当前元素，形成新的递增子序列
			res.add(tmp);
			if (list[i] > max) {
				max = list[i];
				maxIndex = i;
			}
		}
		/*for(int i=0;i<list.length;i++){
			System.out.print(list[i]+" ");
		}*/
		return res.get(maxIndex);
	}
}
