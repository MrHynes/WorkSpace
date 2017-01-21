package spring.init_destroy;

public class data {
	private String name;
	public void setName(String name) {
		System.out.println("setName...");
		this.name = name;
	}
	public data() {
		// TODO Auto-generated constructor stub
		System.out.println("constructor..");
	}
	public void init(){
		System.out.println("init..");
	}

	public void destroy(){
		System.out.println("destroy...");
	}
	@Override
	public String toString() {
		return "data [name=" + name + "]";
	}
	
}
