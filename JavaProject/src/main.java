import Chapter09_ProducerCusomer.CConsumer;
import Chapter09_ProducerCusomer.CProducer;
import Chapter09_ProducerCusomer.Container;

public class main {
	public static void main(String[] args) {
		Container container=new Container();
		CProducer cProducer=new CProducer(container);
		CConsumer cConsumer=new CConsumer(container);
		Thread pro=new Thread(cProducer, "������");
		Thread con=new Thread(cConsumer, "������");
		pro.start();
		con.start();
	}

}
