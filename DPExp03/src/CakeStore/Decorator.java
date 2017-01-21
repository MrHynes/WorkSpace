package CakeStore;

//װ��
public class Decorator implements ICake {

	protected ICake cake;
	private double price=0;
	public  void setCake(ICake cake) {
		this.cake = cake;
	}
	//�������װ�����Ժ󵰸�ļ۸�
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
