package Chapter04_Array;

public class Example4_7_BubbleSort {
	public static void main(String[] args) {
		//冒泡排序
		int score[]={1,2,3,4,5};
		int temp;
		for(int i=1;i<score.length;i++){
			for(int j=0;j<score.length;j++){
				if(score[i]<score[j]){
					temp=score[i];
					score[i]=score[j];
					score[j]=temp;
			}
		}
		System.out.print("第"+i+"次排序结果:");
		for (int k : score) {
			System.out.print(k+" ");
		}
		System.out.println();
	}
		System.out.print("最终的排序结果:");
		for (int i : score) {
			System.out.print(i+" ");
		}
	}
}
