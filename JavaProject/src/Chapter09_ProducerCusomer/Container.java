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
			System.out.println("������"+this.product+"����Ʒ");
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
			System.out.println("���ѵ�"+this.product+"����Ʒ");
			this.product--;
			notifyAll();
		}
	}

}
