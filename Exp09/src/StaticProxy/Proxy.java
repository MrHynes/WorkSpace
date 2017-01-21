package StaticProxy;

public class Proxy implements Subject {

	private RealSubject rs;
	
	public Proxy(RealSubject rs) {
		super();
		this.rs = rs;
	}
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		rs.doSomething();
	}

}
