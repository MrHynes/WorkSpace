package Chapter04_Array;

public class Example4_7_BubbleSort {
	public static void main(String[] args) {
		//ð������
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
		System.out.print("��"+i+"��������:");
		for (int k : score) {
			System.out.print(k+" ");
		}
		System.out.println();
	}
		System.out.print("���յ�������:");
		for (int i : score) {
			System.out.print(i+" ");
		}
	}
}
