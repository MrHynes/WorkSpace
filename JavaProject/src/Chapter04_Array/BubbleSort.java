package Chapter04_Array;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score[]={1,2,3,4,5};
		int temp;
		for(int i=0;i<score.length;i++){
			for(int j=0;j<score.length-1-i;j++){
				if(score[j]>score[j+1]){
					temp=score[j];
					score[j]=score[j+1];
					score[j+1]=temp;
				}
			}
		}
		for (int i : score) {
			System.out.print(i+" ");
		}

	}

}
