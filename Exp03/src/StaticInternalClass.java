
public class StaticInternalClass {
	private static String str="hello static internal class!!";
	static class inner{//静态内部类
		public void print(){
			System.out.println(str);
		}
	};
	public void show(){
		new StaticInternalClass.inner().print();//静态内部类的访问
	}
}
