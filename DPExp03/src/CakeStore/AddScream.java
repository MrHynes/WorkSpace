package CakeStore;
//�������
public class AddScream extends Decorator {
	private double price;
	public AddScream(double price) {
		super();
		this.price = price;
	}
	public void show(){
		super.show();
		System.out.print(" "+"����");
	}
	public void cakePrice(double price){
		super.cakePrice(price+this.price);
	}
}
