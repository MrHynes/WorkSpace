import java.util.Scanner;
public class NumOfPrim {
	public static boolean isPrim(int a) {
		boolean flag = true;
		int i;
		for (i = 2; i < a / 2; i++) {
			if (a % i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		int n;
		int sum = 0;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		int i;
		for (i = 2; i <= n/2; i++) {
			if (isPrim(i) && isPrim(n - i)) {
				sum++;
				System.out.println(i+" "+(n-i));
			}
		}
		System.out.println(sum);
	}

}
