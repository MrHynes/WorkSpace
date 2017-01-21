package testpackage;

public class Customer {
	private Container container;

	public Customer(Container container) {
		this.container = container;
	}

	public void consume() throws Exception {
		String threadName = Thread.currentThread().getName();
		synchronized (container) {
			while (container.isEmpty()) {
				System.out.println(threadName + ":当前货柜为空，暂时不能消费，进入消费");
				container.wait();
				System.out.println(threadName + "被唤醒了");
			}
			Thread.sleep(1000);
			Product product = container.take();
			System.out.println(threadName + ":消费了产品：" + product+"，当前货柜产品总数为："+container.getContainerPointer());
			container.notifyAll();
		}
	}
}
