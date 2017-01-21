package SuperMarketCashier;

public class CTotal {
	private ITotalPrice itp;
	//����ģʽ��򵥹���ģʽ
	//����typeѡ��ͬ�Ĳ���
	public CTotal(String type) {
		switch (type) {
		case "�����":
			itp=new CNationalDay();
			break;
		case "��Ů��":
			itp=new CWomensDay(0.8);
			break;
		case "����":
			itp=new CAnniversary();
			break;
		case "����":
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
