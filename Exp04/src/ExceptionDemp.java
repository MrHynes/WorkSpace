public class ExceptionDemp {
	public static void main(String[] args) {
		int i = 10;
		int j = 0;
		int a[]={1,2,3};
		System.out.println("程序开始");
		try {
			int temp = i / j;
			int temp2=a[3];
			String str = null;
		}catch (ArithmeticException e) {
			System.out.println("算数异常:"+e);
			//e.printStackTrace();
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("数组越界出现异常:"+e);
			//e.printStackTrace();
		}catch (Exception e){
			System.out.println("其他异常:"+e);
			//e.printStackTrace();
		}
		finally{
			System.out.println("程序结束");
		}
	}
}
