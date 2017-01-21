package Chapter04_Array;

public class ArrayInsert {
	// p89ҳ ��10�⡣
	public static void insertNumber(int arr[], int num) {
		int index = 0;
		//�ҵ��������±�
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > num) {
				index = i; // index=3
				break;
			}
		}
		//�½�һ����arr���鳤�ȴ�1������arr2��
		int arr2[] = new int[arr.length + 1];
		for (int j = 0; j < arr.length + 1; j++) {
			if (j < index) {
				arr2[j] = arr[j];
			} else if (j == index)
				arr2[j] = num;
			else {
				arr2[j] = arr[j - 1];
			}
		}
		//�������
		for (int i : arr2) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 5, 6, 7, 8, 9 };
		insertNumber(arr, 4);
	}
}
