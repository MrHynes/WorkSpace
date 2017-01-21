package Chapter06_p213;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Upan upan=new Upan();
		Print print=new Print();
		Computer computer=new Computer();
		computer.plugin(upan);
		computer.plugin(print);
	}

}
