package t01;

public class Student {
	private String stuName;
	private int stuAge;
	private double stuScore;
	public Student(String stuName, int stuAge,double stuScore) {
		super();
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuScore=stuScore;
	}
	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stuAge=" + stuAge
				+ ", stuScore=" + stuScore + "]";
	}
	
	
}
