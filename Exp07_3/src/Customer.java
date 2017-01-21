
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
				System.out.println(threadNmae + ":��ǰ����Ϊ�գ���ʱ�������ѣ���������");
				container.wait();
				System.out.println(threadNmae + "��������");
			}
			Thread.sleep(500);
			Product product=container.take();
			System.out.println(threadNmae + ":������" + product + ",��ǰ��̨�ﻹ��" + container.getiPiont()+"����Ʒ");
			container.notifyAll();
		}
	}

}
