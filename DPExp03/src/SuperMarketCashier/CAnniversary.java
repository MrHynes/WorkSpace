package SuperMarketCashier;

public class CAnniversary implements ITotalPrice{
	@Override
	public double totilPrice(double money) {
		double result=money;
		if(money>=100){
			result=money-Math.floor(money/100.0)*20;//Âú100-20£¬Âú200-40
		}
		return result;
	}
	@Override
	public int totalCredit(double money) {
		return (int)money;
	}
}
