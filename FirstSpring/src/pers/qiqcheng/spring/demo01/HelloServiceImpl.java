package pers.qiqcheng.spring.demo01;

/**
 * ���Ű���ʵ����
 * @author Buer
 *
 */
public class HelloServiceImpl implements HelloService {

	private String info;
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public void sayHello() {
		System.out.println("Hello Spring"+info);
	}

}
