
public class Circle implements Shape {
	private final float PI=3.14159f;
	private float r;
	public Circle(float r) {
		super();
		this.r = r;
	}
	public Circle() {
		super();
	}
	@Override
	public float Perimeter() {
		// TODO Auto-generated method stub
		return 2*PI*r;
	}
	@Override
	public float Area() {
		// TODO Auto-generated method stub
		return PI*r*r;
	}
	

}
