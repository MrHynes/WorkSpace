package CakeStore;

public class main {
	public static void main(String[] args) {
		Cake cake=new Cake();
		System.out.println("��һ�ֵ���");
		AddScream addScream=new AddScream(35);
		AddCandles addCandles=new AddCandles(10);
		AddPack addPack=new AddPack(15);
		addScream.setCake(cake);
		addCandles.setCake(addScream);
		addPack.setCake(addCandles);
		addPack.show();
		System.out.println("�ĵ���.");
		addPack.cakePrice(100);
		
		
		System.out.println("�ڶ��ֵ���");
		Cake cake2=new Cake();
		AddScream addScream2=new AddScream(35);
		AddCard addCard2=new AddCard(5);
		AddPack addPack2=new AddPack(15);
		addScream2.setCake(cake2);
		addCard2.setCake(addScream2);
		addPack2.setCake(addCard2);
		addPack2.show();
		System.out.println("�ĵ���");
		addPack2.cakePrice(100);
	}

}
