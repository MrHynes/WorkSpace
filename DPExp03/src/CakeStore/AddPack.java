package CakeStore;
//��Ӿ�����װ
public class AddPack extends Decorator {
	private double price;
	public AddPack(double price) {
		super();
		this.price = price;
	}
	public void show(){
		super.show();
		System.out.print(" "+"������װ");
	}
	public void cakePrice(double price){
		
		super.cakePrice(price+this.price);
	}
}
