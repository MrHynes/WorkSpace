package Strategy;

public class mian {
	public static void main(String[] args) {
		CashContex cx=new CashContex("打折");
		System.out.println(cx.getMoney(2000));	
		CashContex cx2=new CashContex("正常收费");
		System.out.println(cx2.getMoney(2000));	
		CashContex cx3=new CashContex("满300-100");
		System.out.println(cx3.getMoney(2000));	
	}
}
