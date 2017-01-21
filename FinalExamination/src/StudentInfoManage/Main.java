package StudentInfoManage;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		System.out.println("学生信息管理系统菜单");
		System.out.println("a)添加学生");
		System.out.println("b)删除学生");
		System.out.println("c)浏览学生");
		System.out.println("d)查询学生");
		System.out.println("e)退出系统");
		boolean flag=true;
		String type;
		String ID;
		String name;
		int age;
		float score;
		Scanner scanner=new Scanner(System.in);
		while(flag){
			System.out.print("请输入菜单对应的序号:");
			type=scanner.nextLine();
			switch(type){
			case "a":
				AddStudent addStudent=new AddStudent();
				System.out.println("输入学生信息:学号 姓名 年龄 成绩");
				ID=scanner.nextLine();
				name=scanner.nextLine();
				age=scanner.nextInt();
				score=scanner.nextFloat();
				addStudent.AddStu(ID, name, age, score);
				System.out.println("添加学生信息成功");
				break;
			case "b":
				DeleteStudent deleteStudent=new DeleteStudent();
				System.out.print("请输入需要删除的学生的学号:");
				ID=scanner.nextLine();
				deleteStudent.DelStu(ID);
				System.out.println("删除成功");
				break;
			case "c":
				ShowStudent showStudent=new ShowStudent();
				System.out.println("学生信息如下:");
				showStudent.ShowAllStu();
				break;
			case "d":
				SearchStudent searchStudent=new SearchStudent();
				System.out.print("请输入需要查询学生的姓名");
				name=scanner.nextLine();
				System.out.println("查询的学生姓名为"+name+"的信息如下:");
				searchStudent.SearchStu(name);
				break;
			case "e":
				System.out.println("已经退出系统");
				flag=false;
				break;
			}
		}
	}
}
