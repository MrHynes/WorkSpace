package ThreadApplication;

public class CustomerThread implements Runnable{
	Customer customer;
	public CustomerThread(Customer customer) {
		super();
		this.customer = customer;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
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
