package SuperMarketCashier;

public class CTotal {
	private ITotalPrice itp;
	//策略模式与简单工厂模式
	//根据type选择不同的策略
	public CTotal(String type) {
		switch (type) {
		case "国庆节":
			itp=new CNationalDay();
			break;
		case "妇女节":
			itp=new CWomensDay(0.8);
			break;
		case "店庆":
			itp=new CAnniversary();
			break;
		case "正常":
			itp=new CNormal();
			break;
		default:
			break;
		}
	}
	public double getTotalMoney(double money){
		return itp.totilPrice(money);
	}
	public int getCredit(double money){
		return itp.totalCredit(money);
	}
}
