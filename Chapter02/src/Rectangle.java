
public class Rectangle implements Shape{
	private float length;
	private float width;
	public Rectangle(){
		
	}
	
	public Rectangle(float length, float width) {
		super();
		this.length = length;
		this.width = width;
	}
	@Override
	public float Perimeter() {
		// TODO Auto-generated method stub
		return (length+width)*2;
	}
	@Override
	public float Area() {
		// TODO Auto-generated method stub
		return length*width;
	}
	

}
