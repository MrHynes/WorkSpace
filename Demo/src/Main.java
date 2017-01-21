import java.util.Scanner;


public class Main {

	//排序函数
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
		//创建若干Student 对象
		Student student01=new Student("001","aa",15);
		Student student02=new Student("002","bb",17);
		Student student03=new Student("003","cc",14);
		Student student04=new Student("004","dd",16);
		//定义Student类型的数组，并初始化
		Student []stuArray={student01,student02,student03,student04};
		Main.sort(stuArray);//调用排序函数
		System.out.println("排序后：");
		//输出排序后的结果
		for(int i=0;i<stuArray.length;i++){
			System.out.println(stuArray[i].toString());
		}
	}

}
