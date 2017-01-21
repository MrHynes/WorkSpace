package Chapter04_Array;
public class InsertNumber {
	//p89页第10题，网上的代码
	public static void Test10() {
		// 在排序好的数组插入一个数字，数字要插入到合适的位置上
		int intArr[] = { 11, 22, 33, 44, 55, 66, 77 };
		int insertNum = 34;
		// 找到要插入的位置
		int insertIndex = 0;
		for (int i = 0; i < intArr.length; i++) {
			if (insertNum < intArr[i]) {
				insertIndex = i;
				break;
			}
		}
		// 将insertNum放入要插入的位置，然后后面每个都向后移动一位角标
		int intArr1[] = new int[intArr.length + 1];
		for (int i = 0; i < intArr1.length; i++) {
			if (i >= insertIndex) {
				if (i == insertIndex) // 这个只做一次
					intArr1[i] = insertNum;

				if (i + 1 < intArr1.length) // i+1会越界，加判断
					intArr1[i + 1] = intArr[i];
			} else {
				// 插入之前执行，开始执行插入以后就不执行
				intArr1[i] = intArr[i];
			}
		}
		// 循环输出
		for (int i : intArr1) {
			System.out.print(i + " ");
		}
	}
	public static void main(String[] args) {
		Test10();
	}
}
