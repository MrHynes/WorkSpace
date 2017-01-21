package Chapter13_Map;

public class Person {
	private String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.name.hashCode()*this.age;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj)
			return true;
		if(!(obj instanceof Person))
			return false;
		Person person=(Person) obj;
		if(person.age==this.age&&this.name.equals(person.name)){
			return true;
		}else{
			return false;
		}
	}
}
