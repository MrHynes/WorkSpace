package CakeStore;
//��ˮ��
public class AddFruits extends Decorator {
	private double price;
	public AddFruits(double price) {
		super();
		this.price = price;
	}
	public void show(){
		super.show();
		System.out.print(" "+"��Ƭ");
	}
	//�����ˮ����ļ۸�
	public void cakePrice(double price){
		
		super.cakePrice(price+this.price);
	}
}
