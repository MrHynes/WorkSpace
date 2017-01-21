package Observer;

import java.util.ArrayList;
import java.util.List;

public class Agent implements Subject {
	private String info;
	private List<Observer> observers=new ArrayList<Observer>();
	@Override
	public void Attach(Observer observer) {
		observers.add(observer);
	}
	@Override
	public void Delete(Observer observer) {
		observers.remove(observer);
	}
	@Override
	public void Nptify() {
		for (Observer observer : observers) {
			observer.Update();
		}
	}
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
