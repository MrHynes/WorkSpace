package ThreadApplication;

public class Customer {
	Container container;

	public Customer(Container container) {
		super();
		this.container = container;
	}

	public void consume() throws Exception {
		String threadNmae = Thread.currentThread().getName();//获取当前线程的名字
		synchronized (container) {
			//如果满了，就等待。
			while (container.isEmpty()) {
				System.out.println(threadNmae + ":当前盒子为空，暂时不能消费，稍等再进入消费");
				container.wait();
				System.out.println(threadNmae + "被唤醒了");
			}
			Thread.sleep(500);
			Product product=container.take();//消费产品
			System.out.println(threadNmae + ":消费了" + product + ",当前盒子里还有" + container.getiPiont()+"个产品");
			container.notifyAll();//唤醒所有在等待的线程
		}
	}

}
