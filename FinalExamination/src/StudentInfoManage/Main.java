package StudentInfoManage;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		System.out.println("ѧ����Ϣ����ϵͳ�˵�");
		System.out.println("a)���ѧ��");
		System.out.println("b)ɾ��ѧ��");
		System.out.println("c)���ѧ��");
		System.out.println("d)��ѯѧ��");
		System.out.println("e)�˳�ϵͳ");
		boolean flag=true;
		String type;
		String ID;
		String name;
		int age;
		float score;
		Scanner scanner=new Scanner(System.in);
		while(flag){
			System.out.print("������˵���Ӧ�����:");
			type=scanner.nextLine();
			switch(type){
			case "a":
				AddStudent addStudent=new AddStudent();
				System.out.println("����ѧ����Ϣ:ѧ�� ���� ���� �ɼ�");
				ID=scanner.nextLine();
				name=scanner.nextLine();
				age=scanner.nextInt();
				score=scanner.nextFloat();
				addStudent.AddStu(ID, name, age, score);
				System.out.println("���ѧ����Ϣ�ɹ�");
				break;
			case "b":
				DeleteStudent deleteStudent=new DeleteStudent();
				System.out.print("��������Ҫɾ����ѧ����ѧ��:");
				ID=scanner.nextLine();
				deleteStudent.DelStu(ID);
				System.out.println("ɾ���ɹ�");
				break;
			case "c":
				ShowStudent showStudent=new ShowStudent();
				System.out.println("ѧ����Ϣ����:");
				showStudent.ShowAllStu();
				break;
			case "d":
				SearchStudent searchStudent=new SearchStudent();
				System.out.print("��������Ҫ��ѯѧ��������");
				name=scanner.nextLine();
				System.out.println("��ѯ��ѧ������Ϊ"+name+"����Ϣ����:");
				searchStudent.SearchStu(name);
				break;
			case "e":
				System.out.println("�Ѿ��˳�ϵͳ");
				flag=false;
				break;
			}
		}
	}
}
