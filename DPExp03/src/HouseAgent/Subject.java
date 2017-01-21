package HouseAgent;

public interface Subject {
	public void Attach(Observer observer);
	public void Delete(Observer observer);
	public void NotifyObserver();
	String infomation=null;
	public String getInfomation();
	public void setInfomation(String infomation);
}
