package Strategy;

public class CashContex {
	//����ģʽ�͹���ģʽ�Ľ��
	private ICashSuper iCashSuper=null;

	public CashContex(String type) {
		switch(type){
		case "�����շ�":
			iCashSuper=new CashNormal();
			break;
		case "����":
			iCashSuper=new CashRebate(0.8);
			break;
		case "��300-100":
			iCashSuper=new CashReturn(300, 100);
			break;
		default: break;
		}
	}
	public double getMoney(double money){
		return iCashSuper.cash(money);
	}
}
