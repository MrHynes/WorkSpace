package CakeStore;
//������
public class AddCandles extends Decorator {
	private double price;
	public AddCandles(double price) {
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
