package Chapter06_p214_FactoryClass;

public class mian {
	public static void main(String[] args) {
		//�����Ҫ�������࣬��ô�ͱ���Ҫ����main��������ôҪ��β��ܱ����޸�main�����أ�
		//�𰸾��ǹ�����Factory��fruit.java ���幤����
		/*
		fruit f=new Apple();
		f.eat();
		fruit o=new Orange();
		o.eat();
		*/
		fruit f=null;
		Factory factory=new Factory();
		f=factory.getInstance("apple");
		f.eat();
		f=factory.getInstance("orange");
		f.eat();
	}
}
