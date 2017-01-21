import java.io.Serializable;

@SuppressWarnings("serial")
public class CStudent implements Serializable {
	private String name;
	private int age;
	public CStudent(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "CStudent [name=" + name + ", age=" + age + "]";
	}
	

}
