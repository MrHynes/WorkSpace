import java.util.Scanner;


public class Main {

	//������
	public static void sort(Student stuArray[]){
		for(int i=0;i<stuArray.length;i++){
			for(int j=i+1;j<stuArray.length;j++){
				if(stuArray[i].getStuAge()>stuArray[j].getStuAge()){
					Student temp;
					temp=stuArray[i];
					stuArray[i]=stuArray[j];
					stuArray[j]=temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������Student ����
		Student student01=new Student("001","aa",15);
		Student student02=new Student("002","bb",17);
		Student student03=new Student("003","cc",14);
		Student student04=new Student("004","dd",16);
		//����Student���͵����飬����ʼ��
		Student []stuArray={student01,student02,student03,student04};
		Main.sort(stuArray);//����������
		System.out.println("�����");
		//��������Ľ��
		for(int i=0;i<stuArray.length;i++){
			System.out.println(stuArray[i].toString());
		}
	}

}
