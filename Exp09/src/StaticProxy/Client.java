package StaticProxy;

public class Client {
	public static void main(String[] args) {
		Subject proxy=new Proxy(new RealSubject());
		proxy.doSomething();
	}
}
