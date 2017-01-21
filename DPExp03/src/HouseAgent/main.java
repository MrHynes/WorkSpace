package HouseAgent;

public class main {
	public static void main(String[] args) {
		//中介
		Agent agent=new Agent();
		//中介3个观察者，其中clientB是客户B
		Client client1=new Client("胡汉三", agent);
		Client client2=new Client("曾小贤", agent);
		ClientB clientB=new ClientB("胡一菲", agent);
		//添加观察者
		agent.Attach(client1);
		agent.Attach(client2);
		agent.Attach(clientB);
		//客户B的客户
		ClientOfClientB clientB1=new ClientOfClientB("胡一菲的客户陈美佳", clientB);
		ClientOfClientB clientB2=new ClientOfClientB("胡一菲的客户吕子乔", clientB);
		ClientOfClientB clientB3=new ClientOfClientB("胡一菲的客户唐幽幽", clientB);
		clientB.Attach(clientB1);
		clientB.Attach(clientB2);
		clientB.Attach(clientB3);
		//有新房源了
		agent.setInfomation("有新房源了!快来！");
		//通知观察者
		agent.NotifyObserver();		
	}
}
