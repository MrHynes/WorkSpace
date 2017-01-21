package Chapter09_Thread;

public class CThread extends Thread {
	
	private String name;
	public CThread (String name){
		this.name=name;
	}
	@Override
	public void run() {
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
