package HouseAgent;

import java.util.ArrayList;
import java.util.List;
//�ͻ�B�����ǹ۲���Ҳ�Ǳ��۲��ߣ�������Ҫʵ��Observer��Subect�ӿ�
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
	//��ӿͻ�B�Ŀͻ�
	@Override
	public void Attach(Observer observer) {
		observers.add(observer);
	}

	//ɾ���ͻ�B�Ŀͻ�
	@Override
	public void Delete(Observer observer) {
		observers.remove(observer);
	}
	//֪ͨB�����пͻ�
	@Override
	public void NotifyObserver() {
		for (Observer observer : observers) {
			observer.Update();
		}
	}
	//֪ͨ
	@Override
	public void Update() {
		System.out.println(name+"�ӵ�֪ͨ:"+subject.getInfomation());//���·�Դ��!������
		this.setInfomation(subject.getInfomation());
		this.NotifyObserver();
	}
	//��ȡ������֪ͨ����Ϣ
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
