package Strategy;

public class CashContex {
	//策略模式和工程模式的结合
	private ICashSuper iCashSuper=null;

	public CashContex(String type) {
		switch(type){
		case "正常收费":
			iCashSuper=new CashNormal();
			break;
		case "打折":
			iCashSuper=new CashRebate(0.8);
			break;
		case "满300-100":
			iCashSuper=new CashReturn(300, 100);
			break;
		default: break;
		}
	}
	public double getMoney(double money){
		return iCashSuper.cash(money);
	}
}
