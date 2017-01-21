package testpackage;

public class ProducerThread implements Runnable{
	private Producer producer;
	public ProducerThread(Producer producer) {
		this.producer=producer;
	}
	@Override
	public void run() {
		while(true){
			try {
				producer.produce();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
