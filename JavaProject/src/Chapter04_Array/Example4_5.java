package Chapter04_Array;

public class Example4_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score[]={100,98,87,89,90,93,88,67};
		//求数组中最大值最小值
		int max=0;
		int min=0;
		max=min=score[0];
		for(int i=0;i<score.length;i++){
			if(score[i]>max)
				max=score[i];
			if(score[i]<min)
				min=score[i];
		}
		System.out.println("max="+max+" min="+min);
	}

}
