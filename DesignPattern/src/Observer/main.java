package Observer;

public class main {
	public static void main(String[] args) {
		Agent agent=new Agent();
		ClientA clientA=new ClientA("cleintA",agent);
		ClientB clientB=new ClientB("clientB",agent);
		agent.Attach(clientA);
		agent.Attach(clientB);
		agent.setInfomation("�з�Դ��");
		agent.Nptify();
	}
}
