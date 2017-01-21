package testpackage;

public class Producer {
	private Container container;

	public Producer(Container container) {
		this.container = container;
	}

	public void produce() throws Exception {
		String threadName = Thread.currentThread().getName();
		synchronized (container) {

			while (container.isFull()) {
				System.out.println(threadName + ":当前货柜已满，暂时不能生产，进入等待");
				container.wait();
				System.out.println(threadName + "被唤醒了");
			}
			Thread.sleep(1000);
			Product product = new Product();
			container.put(product);
			System.out.println(threadName + ":生产了产品：" + product+"，当前货柜产品总数为："+container.getContainerPointer());
			container.notifyAll();
		}
	}
}
