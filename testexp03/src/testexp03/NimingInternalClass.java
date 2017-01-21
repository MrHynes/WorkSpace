package testexp03;
interface A{
	public void fun1();
}

public class NimingInternalClass {
	private String string="hello NimingInternalClass";
	public void fun2(A a){
		a.fun1();
	}
	public void show(){
		this.fun2(new A(){
			public void fun1(){
				System.out.println(string);
			}
		});
	}
		

}
