package Chapter09_ProducerCusomer;

public class Container {
	private int product=0;
	public synchronized void addProduct(){
		if(this.product>=5){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			this.product++;
			System.out.println("生产第"+this.product+"个产品");
			notifyAll();
		}
	}
	public synchronized void getProduct(){
		if(this.product<=0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("消费第"+this.product+"个产品");
			this.product--;
			notifyAll();
		}
	}

}
