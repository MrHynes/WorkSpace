package testpackage;

public class Square extends Shape {
	private int l;
	@Override
	public float area() {
		return l*l;
	}
	public Square(int l) {
		super();
		this.l = l;
	}
	
}
