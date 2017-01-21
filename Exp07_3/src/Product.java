
public class Product {
	private int id;
	private static int iNumber=0;
	public Product() {
		this.id=iNumber++;
		//iNumber++;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "²úÆ·"+(id+1);	
	}

}
