package HouseAgent;

public class Client implements Observer{
	private String name;
	private Subject subject;
	public Client(String name, Subject subject) {
		super();
		this.name = name;
		this.subject = subject;
	}
	@Override
	public void Update() {
		System.out.println(name+"接到通知:"+subject.getInfomation());//有新房源了!快来！
	}
}
