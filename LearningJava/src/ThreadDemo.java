import java.util.*;

class demo extends Thread{
	public void run(){
	System.out.println("Thread1!");
	}
}
/*
class demo implements Runnable{
	public void run(){
		System.out.println("Thread1!");
		}
}*/
public class ThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		demo th=new demo();
		Thread reThread=new Thread(th);
		System.out.println(reThread.isAlive());
		reThread.start();
		reThread.setName("123");
		System.out.println(reThread.isAlive());
		System.out.println(reThread.getName());
		System.out.println(reThread);	
	}

}
