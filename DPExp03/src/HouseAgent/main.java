package HouseAgent;

public class main {
	public static void main(String[] args) {
		//�н�
		Agent agent=new Agent();
		//�н�3���۲��ߣ�����clientB�ǿͻ�B
		Client client1=new Client("������", agent);
		Client client2=new Client("��С��", agent);
		ClientB clientB=new ClientB("��һ��", agent);
		//��ӹ۲���
		agent.Attach(client1);
		agent.Attach(client2);
		agent.Attach(clientB);
		//�ͻ�B�Ŀͻ�
		ClientOfClientB clientB1=new ClientOfClientB("��һ�ƵĿͻ�������", clientB);
		ClientOfClientB clientB2=new ClientOfClientB("��һ�ƵĿͻ�������", clientB);
		ClientOfClientB clientB3=new ClientOfClientB("��һ�ƵĿͻ�������", clientB);
		clientB.Attach(clientB1);
		clientB.Attach(clientB2);
		clientB.Attach(clientB3);
		//���·�Դ��
		agent.setInfomation("���·�Դ��!������");
		//֪ͨ�۲���
		agent.NotifyObserver();		
	}
}
