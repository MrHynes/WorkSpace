package Strategy;

public class CashRebate implements ICashSuper{
	private double mRebate;
	public CashRebate(double mRebate) {
		// TODO Auto-generated constructor stub
		this.mRebate=mRebate;
	}
	@Override
	public double cash(double money) {
		// TODO Auto-generated method stub
		return money*this.mRebate;
	}
}
