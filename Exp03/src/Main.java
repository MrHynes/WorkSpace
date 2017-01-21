
public class Main {
//编写程序，分别实践静态内部类、非静态内部类、局部内部类和匿名内部类的定义和使用；
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//非静态内部类
		InternalClass internalClass=new InternalClass(); 
		internalClass.show(); 
		//静态内部类
		StaticInternalClass staticInternalClass=new StaticInternalClass();
		staticInternalClass.show();
		//局部南内部类
		PartInternalClass partInternalClass=new PartInternalClass();
		partInternalClass.fun();
		//匿名内部类
		AnonymityInternalClass anonymityInternalClass=new AnonymityInternalClass();
		anonymityInternalClass.fun();
		
		
	}
}
