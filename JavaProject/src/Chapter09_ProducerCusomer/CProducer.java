package Chapter09_ProducerCusomer;

public class CProducer implements Runnable {
	private Container container;

	public CProducer(Container container) {
		super();
		this.container = container;
	}
	public void run() {
		while(true){
			//System.out.println("生产者开始生产商品");
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			container.addProduct();
		}
	}
}
