package Observer;

public interface Subject {
	public void Attach(Observer observer);
	public void Delete(Observer observer);
	public void Nptify();
	String infomation=null;
	public String getInfomation();
	public void setInfomation(String infomation);
}
