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
				System.out.println(threadName + ":��ǰ������������ʱ��������������ȴ�");
				container.wait();
				System.out.println(threadName + "��������");
			}
			Thread.sleep(1000);
			Product product = new Product();
			container.put(product);
			System.out.println(threadName + ":�����˲�Ʒ��" + product+"����ǰ�����Ʒ����Ϊ��"+container.getContainerPointer());
			container.notifyAll();
		}
	}
}
