package testpackage;

public class MyThread1 implements Runnable{
	
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			try {
				if (i%2==0) {
					System.out.println("ÈÃ³öcpu");
					Thread.yield();
				}
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
		
	}

}
