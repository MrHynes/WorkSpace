package testexp03;
//¾²Ì¬ÄÚ²¿Àà
public class StaticInternalClss {
	private static String str="hello StaticInternalClss";
	static class InnerClass{
		void fun1(){
			System.out.println(str);
		}
	};
	public void show(){
		new StaticInternalClss.InnerClass().fun1();
	}

}
