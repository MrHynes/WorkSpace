package HouseAgent;

public class ClientOfClientB extends ClientB {
	public ClientOfClientB(String name, Subject subject) {
		super(name, subject);
		// TODO Auto-generated constructor stub
	}
	public void Update() {
		System.out.println(name+"�ӵ�֪ͨ:"+subject.getInfomation());//���·�Դ��!������
	}
}
