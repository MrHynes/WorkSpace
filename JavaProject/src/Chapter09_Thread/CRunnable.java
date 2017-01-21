package Chapter09_Thread;

public class CRunnable implements Runnable {

	private String name;
	public CRunnable(String name){
		this.name=name;
	}
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<50;i++){
			System.out.println(name+":"+i);
		}
	}

}
