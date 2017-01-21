package StaticProxy;

public class RealSubject implements Subject {
	@Override
	public void doSomething() {
		System.out.println("do something!");
	}
}
