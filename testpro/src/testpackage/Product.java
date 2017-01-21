package testpackage;

public class Product {
	
	private static int idNumber=0;
	private int id;
	public Product() {
		this.id=idNumber++;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "²úÆ·"+id;
	}
}
