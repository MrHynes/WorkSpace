package CakeStore;
//º”¿Ø÷Ú
public class AddCandles extends Decorator {
	private double price;
	public AddCandles(double price) {
		super();
		this.price = price;
	}
	public void show(){
		super.show();
		System.out.print(" "+"¿Ø÷Ú");
	}
	public void cakePrice(double price){
		super.cakePrice(price+this.price);
	}
}
