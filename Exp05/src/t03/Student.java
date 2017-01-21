package t03;

public class Student implements Comparable<Student>{
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
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if(this.stuAge>o.stuAge){
			return 1;
		}else if(this.stuAge<o.stuAge){
			return -1;
		}else{
			return 0;
		}
	}
}
