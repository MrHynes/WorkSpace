package testpackage;

public class CustomerThread implements Runnable {
	private Customer customer;
	public CustomerThread(Customer customer) {
		this.customer=customer;
	}
	@Override
	public void run() {
		while(true){
			try {
				customer.consume();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
