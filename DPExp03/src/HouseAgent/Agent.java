package HouseAgent;

import java.util.ArrayList;
import java.util.List;

public class Agent implements Subject {
	private List<Observer> observers=new ArrayList<Observer>();
	private String info;
	//添加观察者
	@Override
	public void Attach(Observer observer) {
		observers.add(observer);
	}
	//删除观察者
	@Override
	public void Delete(Observer observer) {
		observers.remove(observer);
	}
	//通知所有观察者
	@Override
	public void NotifyObserver() {
		for (Observer observer : observers) {
			observer.Update();
		}
	}
	//获取和设置通知信息
	@Override
	public String getInfomation() {
		return this.info;
	}
	@Override
	public void setInfomation(String infomation) {
		this.info=infomation;
	}
}
