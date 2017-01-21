package testexp03;

public class PartInternalClass {
	private String str="hello PartInternal Class";
	public void show(){
		class Inner{
			void fun1(){
				System.out.println(str);
			}
		};
		new Inner().fun1();
	}
}
