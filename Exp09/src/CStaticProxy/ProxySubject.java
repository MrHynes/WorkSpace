package CStaticProxy;

public class ProxySubject implements Subject {

	private Subject subject;
	
	public ProxySubject(Subject subject) {
		super();
		this.subject = subject;
	}
	@Override
	public void productClothing() {
		System.out.println("��ȡ�н�ѣ�1000");
		subject.productClothing();
	}

}
