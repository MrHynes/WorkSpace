
public class Producer {
	private Container container;

	public Producer(Container container) {
		super();
		this.container = container;
	}
	public void produce() throws Exception{
		String threadName=Thread.currentThread().getName();
		synchronized (container) {
			while(container.isFull()){
				System.out.println(threadName+ ":当前货柜已满，暂时不能生产，进入等待");
				container.wait();
				System.out.println(threadName+"被唤醒");
			}
			Thread.sleep(500);
			Product product=new Product();
			container.put(product);
			System.out.println(threadName+":生产了" +product+",当前柜台里还有"+container.getiPiont()+"个产品");
			container.notifyAll();
		}
		
	}

}
