package ThreadApplication;

public class ProducerThread implements Runnable {
	Producer producer;
	public ProducerThread(Producer producer) {
		super();
		this.producer = producer;
	}
	@Override
	public void run() {
		
		// TODO Auto-generated method stub
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
