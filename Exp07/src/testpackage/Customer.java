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
				System.out.println(threadName + ":��ǰ����Ϊ�գ���ʱ�������ѣ���������");
				container.wait();
				System.out.println(threadName + "��������");
			}
			Thread.sleep(1000);
			Product product = container.take();
			System.out.println(threadName + ":�����˲�Ʒ��" + product+"����ǰ�����Ʒ����Ϊ��"+container.getContainerPointer());
			container.notifyAll();
		}
	}
}
