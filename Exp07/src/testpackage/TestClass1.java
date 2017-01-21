package testpackage;

public class TestClass1 {
	public static void main(String[] args)  {
		Container container=new Container(5);
		Producer producer=new Producer(container);
		ProducerThread producerThread=new ProducerThread(producer);
		Thread p1=new Thread(producerThread,"p1");
		p1.start();
		Thread p2=new Thread(producerThread,"p2");
		p2.start();
		Thread p3=new Thread(producerThread,"p3");
		p3.start();
		Thread p4=new Thread(producerThread,"p4");
		p4.start();
		Thread p5=new Thread(producerThread,"p5");
		p5.start();
		Customer customer=new Customer(container);
		CustomerThread customerThread=new CustomerThread(customer);
		Thread c1=new Thread(customerThread,"c1");
		c1.start();
		
	}
}