package testpackage;

public class Student{
	private String stuNo;
	private String name;
	private int age;
	private int score;
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}

	public Student(String stuNo, String name, int age,int score) {
		super();
		this.stuNo = stuNo;
		this.name = name;
		this.age = age;
		this.score=score;
	}

	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", name=" + name + ", age=" + age + ", score=" + score + "]";
	}

	@Override
	public int hashCode() {
		return stuNo.hashCode()+age;
	}

	@Override
	public boolean equals(Object obj) {
		Student o=(Student) obj;
		if (this.stuNo.equals(o.stuNo)&&this.age==o.age) {
			return true;
		}
		return false;
	}


		
	

}
