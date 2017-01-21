package laerningJava.chapter01;
class test implements Runnable{
	int i=1;
	String nameString;
	public test(String nameString) {
		super();
		this.nameString = nameString;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(i<=10){
		System.out.println("吃第"+i+"个"+nameString);
		i++;
		}
	}
}
public class testRunnable {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		test obTest=new test("包子");
		test obTest2=new test("馒头");
		Thread thread=new Thread(obTest);
		Thread thread2=new Thread(obTest2);
		thread.start();
		thread2.start();
	}
}
