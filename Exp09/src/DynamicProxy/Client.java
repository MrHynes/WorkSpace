package DynamicProxy;

public class Client {
	public static void main(String[] args) {
		ProxyHandler ph=new ProxyHandler();
		Subject sj=(Subject) ph.bind(new RealSubject());
		sj.doSomething();
	}
}
