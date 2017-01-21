package laerningJava.chapter01;

class eat extends Thread{
	@Override
	public  void run() {
	for(int i=0;i<20;i++){
		try {
			sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("³Ô·¹");
		}
	}
}
class music extends Thread{
	@Override
	public void run() {
		for(int i=0;i<20;i++){
		try {
			sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ÌýÒôÀÖ");
		}
	}
}
public class testThread {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		eat e=new eat();
		e.start();
		music m=new music();
		m.start();
	}
}
