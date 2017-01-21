/*
 * 1、定义学生类：Student，要求包含学号、姓名和年龄属性；
 * 2、定义一个学生数组，存放若干个学生对象，然后度数组中的对象，按学生年龄从小到大排序。
 * 
 */
public class Student {
	private String stuID;
	private String stuName;
	private int stuAge;
	public Student(){
		
	}
	public Student(String stuID,String stuName,int stuAge){
		this.stuID=stuID;
		this.stuName=stuName;
		this.setStuAge(stuAge);
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	@Override
	public String toString() {
		return "Student [stuID=" + stuID + ", stuName=" + stuName + ", stuAge="
				+ stuAge + "]";
	}
	
}
