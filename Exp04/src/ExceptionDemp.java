public class ExceptionDemp {
	public static void main(String[] args) {
		int i = 10;
		int j = 0;
		int a[]={1,2,3};
		System.out.println("����ʼ");
		try {
			int temp = i / j;
			int temp2=a[3];
			String str = null;
		}catch (ArithmeticException e) {
			System.out.println("�����쳣:"+e);
			//e.printStackTrace();
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("����Խ������쳣:"+e);
			//e.printStackTrace();
		}catch (Exception e){
			System.out.println("�����쳣:"+e);
			//e.printStackTrace();
		}
		finally{
			System.out.println("�������");
		}
	}
}
