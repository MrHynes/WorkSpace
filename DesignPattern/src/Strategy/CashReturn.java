package Strategy;


public class CashReturn implements ICashSuper{
	private double monCondition;
	private double monReturn;
	public CashReturn(double monCondition,double monReturn){
		this.monCondition=monCondition;
		this.monReturn=monReturn;
	}
	@Override
	public double cash(double money) {
		// TODO Auto-generated method stub
		double result=money;
		if(money>this.monCondition){
		  result=money-Math.floor(money/this.monCondition)*this.monReturn;
		}
		return result;
	}
}
