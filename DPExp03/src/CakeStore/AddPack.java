package CakeStore;
//添加精美包装
public class AddPack extends Decorator {
	private double price;
	public AddPack(double price) {
		super();
		this.price = price;
	}
	public void show(){
		super.show();
		System.out.print(" "+"精美包装");
	}
	public void cakePrice(double price){
		
		super.cakePrice(price+this.price);
	}
}
