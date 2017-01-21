interface A{
	public void print();
}
public class AnonymityInternalClass {
	private String str="hello anonymity internal class";
	public void fun2(A a){
		a.print();
	}
	public void fun(){
		this.fun2(new A(){
			public void print(){
				System.out.println(str);
			}
		});
	}
}
