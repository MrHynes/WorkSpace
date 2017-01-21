package Chapter09_Thread;

public class CRunnablemain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CRunnable thread1=new CRunnable("线程1");
		CRunnable thread2=new CRunnable("线程2");
		Thread t1=new Thread(thread1);
		Thread t2=new Thread(thread2);
		t1.start();
		t2.start();
	}

}
