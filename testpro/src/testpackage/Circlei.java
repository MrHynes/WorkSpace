package testpackage;

public class Circlei implements Shapei{
	private double r;
	
	public Circlei(double r) {
		super();
		this.r = r;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	@Override
	public double area() {
		return PI*r*r;
	}

	@Override
	public double length() {
		// TODO Auto-generated method stub
		return 0;
	}

}
