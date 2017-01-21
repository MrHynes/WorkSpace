package HouseAgent;

import java.util.ArrayList;
import java.util.List;
//客户B不仅是观察者也是被观察者，所以他要实现Observer和Subect接口
public class ClientB  implements Subject,Observer{
	private List<Observer> observers=new ArrayList<Observer>();
	protected String info;
	protected String name;
	protected Subject subject;
	public ClientB(String name, Subject subject) {
		super();
		this.name = name;
		this.subject = subject;
	}
	//添加客户B的客户
	@Override
	public void Attach(Observer observer) {
		observers.add(observer);
	}

	//删除客户B的客户
	@Override
	public void Delete(Observer observer) {
		observers.remove(observer);
	}
	//通知B的所有客户
	@Override
	public void NotifyObserver() {
		for (Observer observer : observers) {
			observer.Update();
		}
	}
	//通知
	@Override
	public void Update() {
		System.out.println(name+"接到通知:"+subject.getInfomation());//有新房源了!快来！
		this.setInfomation(subject.getInfomation());
		this.NotifyObserver();
	}
	//获取和设置通知的信息
	@Override
	public String getInfomation() {
		// TODO Auto-generated method stub
		return this.info;
	}
	@Override
	public void setInfomation(String infomation) {
		this.info=infomation;
	}
}
