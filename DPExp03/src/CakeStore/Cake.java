package CakeStore;

public class Cake implements ICake {
	private double price=0;//����ԭ��
	//���㵰���ܼ�
	@Override
	public void cakePrice(double price) {
		System.out.print("�ܼ�:");
		this.price+=price;
		System.out.println(this.price);
	}
	//��ʾ���������ʲô
	@Override
	public void show() {
		System.out.print("��");
	}
}
