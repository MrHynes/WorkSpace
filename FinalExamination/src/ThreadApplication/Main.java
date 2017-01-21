package ThreadApplication;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Container container=new Container(3);
		Producer producer=new Producer(container);
		ProducerThread producerThread=new ProducerThread(producer);
		//两个生产者
		Thread p1=new Thread(producerThread,"p1");
		p1.start();
		Thread p2=new Thread(producerThread,"p2");
		p2.start();
		Customer customer=new Customer(container);
		CustomerThread customerThread=new CustomerThread(customer);
		//四个消费者
		Thread c1=new Thread(customerThread, "c1");
		c1.start();
		Thread c2=new Thread(customerThread, "c2");
		c2.start();
		Thread c3=new Thread(customerThread, "c3");
		c3.start();
		Thread c4=new Thread(customerThread, "c4");
		

	}

}
