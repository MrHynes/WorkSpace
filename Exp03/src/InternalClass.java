public class InternalClass {

	private String str="hello internal class!!";
	class inner{ //�����ڲ���
		void print(){
			System.out.println(str);
		}
	};
	public void show(){
		new inner().print();//ͨ���ڲ��������÷���
	}
}
