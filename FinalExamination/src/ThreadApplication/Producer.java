package ThreadApplication;

public class Producer {
	private Container container;

	public Producer(Container container) {
		super();
		this.container = container;
	}
	public void produce() throws Exception{
		String threadName=Thread.currentThread().getName();
		//ͬ�������
		synchronized (container) {
			while(container.isFull()){
				System.out.println(threadName+ ":��ǰ������������ʱ��������������ȴ�");
				container.wait();//�ȴ�
				System.out.println(threadName+"������");
			}
			Thread.sleep(500);
			Product product=new Product();
			container.put(product);//�������Ĳ�Ʒ��������
			System.out.println(threadName+":������" +product+",��ǰ�����ﻹ��"+container.getiPiont()+"����Ʒ");
			//�������еȴ����߳�
			container.notifyAll();
		}
		
	}

}
