package Chapter04_Array;

public class ArrayOverTure {
	public static void main(String[] args) {
		//������Ϊ10��������β��
		//��p89ҳ��6��
		int arr[]={0,1,2,3,4,5,6,7,8,9,10};
		int temp;
		for(int i=0;i<arr.length/2;i++){
			temp=arr[i];
			arr[i]=arr[arr.length-i-1];
			arr[arr.length-i-1]=temp;
		}
		for (int j: arr) {
			System.out.print(j+" ");
		}
	}

}
