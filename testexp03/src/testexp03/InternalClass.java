package testexp03;
//ÄÚ²¿Àà
public class InternalClass {
	private String str="hello Internal Class";
	class Inner{
		void funInner(){
			System.out.println(str);
		}		
	};
	public void show(){
		new Inner().funInner();
	}
}
