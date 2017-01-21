package CakeStore;
//¼Ó¿¨Æ¬
public class AddCard extends Decorator {
	private double price;
	public AddCard(double price) {
		super();
		this.price = price;
	}
	public void show(){
		super.show();
		System.out.print(" "+"Ë®¹û");
	}
	public void cakePrice(double price){
		
		super.cakePrice(price+this.price);
	}
}
