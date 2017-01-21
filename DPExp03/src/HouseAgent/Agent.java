package HouseAgent;

import java.util.ArrayList;
import java.util.List;

public class Agent implements Subject {
	private List<Observer> observers=new ArrayList<Observer>();
	private String info;
	//��ӹ۲���
	@Override
	public void Attach(Observer observer) {
		observers.add(observer);
	}
	//ɾ���۲���
	@Override
	public void Delete(Observer observer) {
		observers.remove(observer);
	}
	//֪ͨ���й۲���
	@Override
	public void NotifyObserver() {
		for (Observer observer : observers) {
			observer.Update();
		}
	}
	//��ȡ������֪ͨ��Ϣ
	@Override
	public String getInfomation() {
		return this.info;
	}
	@Override
	public void setInfomation(String infomation) {
		this.info=infomation;
	}
}
