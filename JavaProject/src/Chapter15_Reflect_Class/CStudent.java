package Chapter15_Reflect_Class;

public class CStudent {
	private String name;
	private int age;
	public CStudent(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public CStudent() {
		super();
	}
	@Override
	public String toString() {
		return "CStudent [name=" + name + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void sayHello(String name){
		System.out.println(name+"say hello!");
	}

}
