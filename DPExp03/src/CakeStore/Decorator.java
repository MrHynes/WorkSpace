package CakeStore;

//装饰
public class Decorator implements ICake {

	protected ICake cake;
	private double price=0;
	public  void setCake(ICake cake) {
		this.cake = cake;
	}
	//计算添加装饰了以后蛋糕的价格
	@Override
	public void cakePrice(double price) {
		this.price=price;
		if(cake!=null){
			cake.cakePrice(price);
		}
	}
	@Override
	public void show() {
		if(cake!=null){
			cake.show();
		}
	}
}
