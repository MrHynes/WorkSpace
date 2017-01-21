package Chapter04_Array;

public class Example4_6_Sort {
	public static void main(String[] args) {
		int score[]={100,98,87,89,90,93,88,67};
		int temp;
		for(int i=0;i<score.length;i++)
			for(int j=i+1;j<score.length;j++)
				if(score[i]<score[j]){
					temp=score[i];
					score[i]=score[j];
					score[j]=temp;
				}
		for (int i : score) {
			System.out.print(i+" ");
		}
	}

}
