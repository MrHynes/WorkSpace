package Chapter09_ProducerCusomer;

public class CConsumer implements Runnable {
	private Container container;

	public CConsumer(Container container) {
		super();
		this.container = container;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("消费者取走商品");
			container.getProduct();
		}
	}
}
