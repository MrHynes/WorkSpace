package CakeStore;
//加水果
public class AddFruits extends Decorator {
	private double price;
	public AddFruits(double price) {
		super();
		this.price = price;
	}
	public void show(){
		super.show();
		System.out.print(" "+"卡片");
	}
	//计算加水果后的价格
	public void cakePrice(double price){
		
		super.cakePrice(price+this.price);
	}
}
