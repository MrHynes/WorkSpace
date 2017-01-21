package testpackage;

public class MyThread2 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName()+":"+i);
		}
		System.out.println(Thread.currentThread().getName()+"½áÊø");
	}

}
