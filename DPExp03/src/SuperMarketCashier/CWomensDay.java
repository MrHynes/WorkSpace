package SuperMarketCashier;

public class CWomensDay implements ITotalPrice {
	private  double moneyRebate; 	
	public CWomensDay(double moneyRebate) {
		super();
		this.moneyRebate = moneyRebate;
	}
	@Override
	public double totilPrice(double money) {
		return this.moneyRebate*money;//��Ů�ڴ���
	}
	@Override
	public int totalCredit(double money) {
		return (int)money;
	}
}
