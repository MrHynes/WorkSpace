/*
 * 1������ѧ���ࣺStudent��Ҫ�����ѧ�š��������������ԣ�
 * 2������һ��ѧ�����飬������ɸ�ѧ������Ȼ��������еĶ��󣬰�ѧ�������С��������
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
