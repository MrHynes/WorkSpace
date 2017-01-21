package CakeStore;

public class Cake implements ICake {
	private double price=0;//蛋糕原价
	//计算蛋糕总价
	@Override
	public void cakePrice(double price) {
		System.out.print("总价:");
		this.price+=price;
		System.out.println(this.price);
	}
	//显示往蛋糕加了什么
	@Override
	public void show() {
		System.out.print("加");
	}
}
