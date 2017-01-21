package Chapter15_reflect;

public class CPerson {
	private String name;
	private int age;
	public CPerson(){
	}

	public CPerson(String name,int age){
		this.name=name;
		this.age=age;
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

	@Override
	public String toString() {
		return "CPerson [name=" + name + ", age=" + age + "]";
	}
	
	
}
