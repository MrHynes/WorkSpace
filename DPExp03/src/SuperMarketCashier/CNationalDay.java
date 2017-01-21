package SuperMarketCashier;

public class CNationalDay implements ITotalPrice{	
	@Override
	public double totilPrice(double money) {
		// TODO Auto-generated method stub
		return money;
	}
	@Override
	public int totalCredit(double money) {
		// TODO Auto-generated method stub
		return (int)(money*2);//国庆节积分双倍
	}
}
