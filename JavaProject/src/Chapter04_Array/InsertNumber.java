package Chapter04_Array;
public class InsertNumber {
	//p89ҳ��10�⣬���ϵĴ���
	public static void Test10() {
		// ������õ��������һ�����֣�����Ҫ���뵽���ʵ�λ����
		int intArr[] = { 11, 22, 33, 44, 55, 66, 77 };
		int insertNum = 34;
		// �ҵ�Ҫ�����λ��
		int insertIndex = 0;
		for (int i = 0; i < intArr.length; i++) {
			if (insertNum < intArr[i]) {
				insertIndex = i;
				break;
			}
		}
		// ��insertNum����Ҫ�����λ�ã�Ȼ�����ÿ��������ƶ�һλ�Ǳ�
		int intArr1[] = new int[intArr.length + 1];
		for (int i = 0; i < intArr1.length; i++) {
			if (i >= insertIndex) {
				if (i == insertIndex) // ���ֻ��һ��
					intArr1[i] = insertNum;

				if (i + 1 < intArr1.length) // i+1��Խ�磬���ж�
					intArr1[i + 1] = intArr[i];
			} else {
				// ����֮ǰִ�У���ʼִ�в����Ժ�Ͳ�ִ��
				intArr1[i] = intArr[i];
			}
		}
		// ѭ�����
		for (int i : intArr1) {
			System.out.print(i + " ");
		}
	}
	public static void main(String[] args) {
		Test10();
	}
}
