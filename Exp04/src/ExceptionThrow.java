
public class ExceptionThrow {
	public static  float div(int i,int j)throws Exception{
		int temp=i/j;
		return temp;
	}
	//Exception �����б���ʹ��try...catch ����
	public static void main(String []args){
		try {
			ExceptionThrow.div(1,0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
