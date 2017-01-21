import org.omg.CORBA.PUBLIC_MEMBER;


public class PartInternalClass {
	private String str="helle part internal class";
	public void fun(){
		class inner{//局部内部类
			public void print(){
				System.out.println(str);
			}
		};
		new inner().print();
	}
}
