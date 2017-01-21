package Chapter09_Thread;

public class CThreadmain {
	public static void main(String[] args) {
		CThread thread1=new CThread("Thread1");
		CThread thread2=new CThread("Thread2");
		thread1.start();
		thread2.start();
	}

}
