package Chapter05.execise;

public class FinfTwoNumberEqualsX5_33 {

	/**
	 * ��һ������������У��ҵ������������ǵ�ֵ���õ���x
	 * @param a ����
	 * @param low 
	 * @param high
	 * @param x
	 */
	public  static void findTwoNumber(int a[],int low,int high,int x){
		boolean flag=false;
		while(low<high&&!flag){
			if(a[low]+a[high]>x){
				high--;
			}
			else if(a[low]+a[high]<x){
				low++;
			}
			else {
				flag=true;
			}
		}
		if(flag){
			System.out.println(a[low]+"+"+a[high]+"="+x);
		}else {
			System.out.println("NO");
		}
	}
	public static void main(String[] args) {
		int a[]={1,2,3,4,5,6,7,8,9,10};
		for(int i=11;i<19;i++)
		findTwoNumber(a, 0, a.length-1,i);
	}
}