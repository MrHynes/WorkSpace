package SuperMarketCashier;

public class CNormal implements ITotalPrice {
	@Override
	public double totilPrice(double money) {
		return money;
	}
	@Override
	public int totalCredit(double money) {
		return (int)money;
	}
}
