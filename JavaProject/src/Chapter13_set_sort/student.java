package Chapter13_set_sort;

public class student implements Comparable<student> {
	private String name;
	private int age;

	public student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
		return "student [name=" + name + ", age=" + age + "]";
	}

	public int compareTo(student o) {
		if (this.age > o.age) {
			return 1;
		} else if (this.age < o.age) {
			return -1;
		} else {
			return 0;
		}
	}
	//¸²Ğ´equals£¬hashCode·½·¨
		@Override
		public int hashCode() {
			return this.name.hashCode()*this.age;
		}

		@Override
		public boolean equals(Object obj) {
			if(this==obj){
				return true;
			}
			if(!(obj instanceof student)){
				return false;
			}
			student p=(student)obj;
			if(this.age==p.age&&this.name==p.name){
				return true;
			}
			else{
				return false;
			}
		}
	
}
