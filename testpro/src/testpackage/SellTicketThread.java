package testpackage;

public class SellTicketThread implements Runnable {
	private TicketOffice ticketOffice;
	public SellTicketThread(TicketOffice ticketOffice) {
		this.ticketOffice=ticketOffice;
	}
	@Override
	public void run() {
		while (true) {
			if (!ticketOffice.sellTicket())
				break;
		}
	}
	
}
