package Chapter09_ThreadOper;

public class CSynchronizedMain {
	public static void main(String[] args) {
		CThreadSynchronized t1=new CThreadSynchronized();
		new Thread(t1).start();
		new Thread(t1).start();
		new Thread(t1).start();
	}

}
