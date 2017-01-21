package testpackage;

public class Container {
	private int capacity;
	private int containerPointer=0;
	private Product[]products;
	public Container(int capacity) {
		this.capacity=capacity;
		this.products=new Product[capacity];
	}
	public int getContainerPointer() {
		return containerPointer;
	}
	public boolean isFull(){
		if (containerPointer==capacity) {
			return true;
		}
		return false;
	}
	public boolean isEmpty(){
		if (containerPointer==0) {
			return true;
		}
		return false;
	}
	public void put(Product product){
		this.products[containerPointer]=product;
		containerPointer++;
	}
	public Product take(){
		containerPointer--;
		Product product= this.products[containerPointer];
		return product;
	}

	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Product[] getProducts() {
		return products;
	}
	public void setProducts(Product[] products) {
		this.products = products;
	}
	
}
