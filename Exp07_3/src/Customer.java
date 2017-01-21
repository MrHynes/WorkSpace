
public class Customer {
	Container container;

	public Customer(Container container) {
		super();
		this.container = container;
	}

	public void consume() throws Exception {
		String threadNmae = Thread.currentThread().getName();
		synchronized (container) {
			while (container.isEmpty()) {
				System.out.println(threadNmae + ":当前货柜为空，暂时不能消费，进入消费");
				container.wait();
				System.out.println(threadNmae + "被唤醒了");
			}
			Thread.sleep(500);
			Product product=container.take();
			System.out.println(threadNmae + ":消费了" + product + ",当前柜台里还有" + container.getiPiont()+"个产品");
			container.notifyAll();
		}
	}

}
