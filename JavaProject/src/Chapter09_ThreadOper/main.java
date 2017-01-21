package Chapter09_ThreadOper;

public class main {
	public static void main(String[] args) throws Exception {
		CThread ct1=new CThread();
		Thread t1=new Thread(ct1,"线程t1");
		System.out.println(t1.isAlive());
		Thread t2=new Thread(ct1,"线程t2");
		System.out.println(t2.isAlive());
		//t1.setDaemon(true);//设置为守护线程
		t1.start();
		t2.start();
		for(int i=0;i<10;i++){
			if(i==5){
				t1.join();
			}
			System.out.println("main线程运行");
		}
		//ct1.run();
		System.out.println(t1.isAlive());
		System.out.println(t2.isAlive());
	}
}
