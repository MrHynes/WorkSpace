package testpackage;

public class TestClass {
	public static void main(String[] args)  {
		
		
		TicketOffice ticketOffice1=new TicketOffice(50);
//		TicketOffice ticketOffice2=new TicketOffice(50);
		SellTicketThread sellTicketTread1=new SellTicketThread(ticketOffice1);
//		SellTicketThread sellTicketTread2=new SellTicketThread(ticketOffice2);
		Thread t1=new Thread(sellTicketTread1,"t1");
		t1.start();
		Thread t2=new Thread(sellTicketTread1,"t2");
		t2.start();
		Thread t3=new Thread(sellTicketTread1,"t3");
		t3.start();
	}
}