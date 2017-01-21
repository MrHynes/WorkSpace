package Chapter04_Array;
import java.lang.*;
public class CreateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建数组的方法1
		int a[]=null;//申明一个数组，数组名为a，存在栈中。
		a=new int[3];//使用new关键字为数组分配堆内存空间
		//方法2
		int b[]=new int[3];
		//输出数组中的元素 foreach
		for (int i : b) {
			System.out.println(i);
		}
		//如果访问数组下标超过数组的长度
		try
		{
			System.out.println(b[4]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		//申明一个数组并给数组赋值，在遍历数组输出内容
		int arr[]={1,2,3,4,5,6,7,8,9};//数组静态初始化
		//输出方式1
		for (int i : arr) {
			System.out.print(i+" ");
		}
		//输出方法2
		System.out.println();
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

}
