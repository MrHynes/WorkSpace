package Chapter06;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortArray sortArray=new SortArray(3);
		sortArray.add(3);
		sortArray.add(4);
		sortArray.add(1);
		System.out.println("数组排序");
		print(sortArray.getArray());
		
		ReverseArray reverseArray=new ReverseArray(4);
		reverseArray.add(1);
		reverseArray.add(2);
		reverseArray.add(3);
		reverseArray.add(4);
		System.out.println("数组反转");
		print(reverseArray.getArray());

	}
	public static void print(int temp[]){
		for (int i : temp) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
