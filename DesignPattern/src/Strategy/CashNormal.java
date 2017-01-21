package Strategy;

public class CashNormal implements ICashSuper{
	@Override
	public double cash(double money) {
		return money;
	}
}
