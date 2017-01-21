package t04;

import java.util.Comparator;

public class Student implements Comparator<Student>{
	private String stuName;
	private int stuAge;
	private double stuScore;
	public Student(String stuName, int stuAge,double stuScore) {
		super();
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuScore=stuScore;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stuAge=" + stuAge
				+ ", stuScore=" + stuScore + "]";
	}
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		if(o1.stuScore>o2.stuScore){
			return 1;
		}else if(o1.stuScore<o2.stuScore){
			return -1;
		}else{
			return 0;
		}
	}
}
