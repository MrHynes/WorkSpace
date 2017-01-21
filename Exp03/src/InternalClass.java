public class InternalClass {

	private String str="hello internal class!!";
	class inner{ //定义内部类
		void print(){
			System.out.println(str);
		}
	};
	public void show(){
		new inner().print();//通过内部类对象调用方法
	}
}
