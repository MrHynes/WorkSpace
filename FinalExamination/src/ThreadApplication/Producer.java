package ThreadApplication;

public class Producer {
	private Container container;

	public Producer(Container container) {
		super();
		this.container = container;
	}
	public void produce() throws Exception{
		String threadName=Thread.currentThread().getName();
		//同步代码块
		synchronized (container) {
			while(container.isFull()){
				System.out.println(threadName+ ":当前盒子已满，暂时不能生产，进入等待");
				container.wait();//等待
				System.out.println(threadName+"被唤醒");
			}
			Thread.sleep(500);
			Product product=new Product();
			container.put(product);//将生产的产品加入容器
			System.out.println(threadName+":生产了" +product+",当前盒子里还有"+container.getiPiont()+"个产品");
			//唤醒所有等待的线程
			container.notifyAll();
		}
		
	}

}
