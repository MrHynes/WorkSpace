package testpackage;

public class TicketOffice {
	private int ticketNumber;

	public TicketOffice(int ticketNumber) {
		super();
		this.ticketNumber = ticketNumber;
	}
	
	 public boolean sellTicket(){
		String threadName=Thread.currentThread().getName();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized (this) {
			if (ticketNumber > 0) {
				System.out.println(threadName + "��Ʊ�ɹ����۳�Ʊ��Ϊ��" + ticketNumber);
				ticketNumber--;
				return true;
			}
		}
		System.out.println("Ʊ�����꣡����");
		return false;
	}

}
