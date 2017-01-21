package Chapter09_ThreadOper;

public class CThreadSynchronized implements Runnable {

	private int ticket = 5;

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			synchronized (this) {
				if (ticket > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("ÂôÆ±£¬ticker=" + ticket--);
				}
			}
		}
	}

}
