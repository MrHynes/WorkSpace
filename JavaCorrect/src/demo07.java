
public class demo07 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i1=1;
		int i2=1;
		Integer i3=new Integer(1);
		Integer i4=new Integer(1);
		System.out.println(i1==i2);//ֵ��ͬ Y
		System.out.println(i3==i4);//ֵ��ͬ�����ǲ�����ͬ���� N
		System.out.println(i1==i3);//ֵ��ͬY
		System.out.println(i3.equals(i1));//������ͬ Y
		System.out.println(i3.equals(i4));//��ͬ����������ͬY
		System.out.println(i4.equals(i3));//Y
		
		String s1="a";
		String s2="a";
		String s3=new String("a");
		String s4=new String("a"); 
		System.out.println(s1==s2);//Y
		System.out.println(s1==s3);//N ������ͬ����
		System.out.println(s3==s4);//N ������ͬ����
		System.out.println(s3.equals(s1));//y
		System.out.println(s3.equals(s4));//y
		System.out.println(s3.equals(s4));//y

	}

}
