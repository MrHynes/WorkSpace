package ThreadApplication;

public class Container {
	private int iNumber;
	private int iPiont=0;
	private Product[] Products;//存放货品的容器
	
	public Container(int iNumber) {
		super();
		this.iNumber = iNumber;
		this.Products=new Product[iNumber];
	}
	public boolean isFull(){
		if(iNumber==iPiont)
			return true;
		else
			return false;
	}
	public boolean isEmpty(){
		if(iPiont==0)
			return true;
		else
			return false;
	}
	public int getiNumber() {
		return iNumber;
	}
	public void setiNumber(int iNumber) {
		this.iNumber = iNumber;
	}
	public int getiPiont() {
		return iPiont;
	}
	
	public Product[] getProducts() {
		return Products;
	}
	public void setProducts(Product[] products) {
		Products = products;
	}
	public void put(Product products){//加入产品到容器中
		this.Products[iPiont]=products;
		this.iPiont++;
	}
	public Product take(){//消费产品
		this.iPiont--;
		Product product=this.Products[iPiont];
		return product;
	}
	
}

