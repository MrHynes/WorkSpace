
public class StaticInternalClass {
	private static String str="hello static internal class!!";
	static class inner{//��̬�ڲ���
		public void print(){
			System.out.println(str);
		}
	};
	public void show(){
		new StaticInternalClass.inner().print();//��̬�ڲ���ķ���
	}
}
