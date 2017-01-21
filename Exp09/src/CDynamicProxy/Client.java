package CDynamicProxy;

public class Client {
	public static void main(String[] args) {
		DynaminProxyHander hander=new DynaminProxyHander();
		Subject cf=(Subject) hander.bind(new RealSubject());
		cf.productClothing();
	}
}
