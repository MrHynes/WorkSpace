package Chapter04_Array;
import java.lang.*;
public class CreateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������ķ���1
		int a[]=null;//����һ�����飬������Ϊa������ջ�С�
		a=new int[3];//ʹ��new�ؼ���Ϊ���������ڴ�ռ�
		//����2
		int b[]=new int[3];
		//��������е�Ԫ�� foreach
		for (int i : b) {
			System.out.println(i);
		}
		//������������±곬������ĳ���
		try
		{
			System.out.println(b[4]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		//����һ�����鲢�����鸳ֵ���ڱ��������������
		int arr[]={1,2,3,4,5,6,7,8,9};//���龲̬��ʼ��
		//�����ʽ1
		for (int i : arr) {
			System.out.print(i+" ");
		}
		//�������2
		System.out.println();
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

}
