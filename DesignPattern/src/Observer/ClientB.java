package Observer;

public class ClientB extends Observer {
	private Subject subject;
	private String name;
	public ClientB(String name,Subject subject) {
		super();
		this.name=name;
		this.subject = subject;
	}
	@Override
	public void Update() {
		System.out.println(this.name+this.subject.getInfomation());
	}
}
