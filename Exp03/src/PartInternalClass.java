import org.omg.CORBA.PUBLIC_MEMBER;


public class PartInternalClass {
	private String str="helle part internal class";
	public void fun(){
		class inner{//�ֲ��ڲ���
			public void print(){
				System.out.println(str);
			}
		};
		new inner().print();
	}
}
