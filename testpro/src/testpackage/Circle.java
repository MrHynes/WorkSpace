package testpackage;

public class Circle extends Shape {
	public static float PI=3.1415926f;
	private int r;
	private static Circle circle=new Circle(10);
	public static Circle getInstance() {
		return circle;
	}
	@Override
	public float area() {
		return PI*r*r;
	}
	private Circle(int r) {
		super();
		this.r = r;
	}
	
	public float test() {
		return area();
	}
}
