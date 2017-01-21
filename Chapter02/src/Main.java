
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shape rec=new Rectangle(1,2);
		System.out.println("长方形的面积为："+rec.Area());
		System.out.println("长方形的周长为："+rec.Perimeter());
		
		Shape cir=new Circle(1);
		System.out.println("圆的面积为："+cir.Area());
		System.out.println("圆的周长为："+cir.Perimeter());
	}
}
