package Chapter09_ThreadOper;

public class CThread implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==5){
				Thread.yield();System.out.println(Thread.currentThread().getName()+"ÀñÈÃ");
			}
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
	

}
