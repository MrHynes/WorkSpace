package testpackage;

public class Outer {
	private static int a=10;
	public int sum(){
		int d=100;
		class Inner{
			private int b;
			private int c;
			public int getB() {
				return b;
			}
			public void setB(int b) {
				this.b = b;
			}
			public int getC() {
				return c;
			}
			public void setC(int c) {
				this.c = c;
			}
			public int sum() {
				return a+b+c+d;
			}
			
		}
		Inner inner=new Inner();
		inner.setB(10);
		inner.setC(20);
		return inner.sum();
	}
	

}
