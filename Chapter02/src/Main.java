
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shape rec=new Rectangle(1,2);
		System.out.println("�����ε����Ϊ��"+rec.Area());
		System.out.println("�����ε��ܳ�Ϊ��"+rec.Perimeter());
		
		Shape cir=new Circle(1);
		System.out.println("Բ�����Ϊ��"+cir.Area());
		System.out.println("Բ���ܳ�Ϊ��"+cir.Perimeter());
	}
}
