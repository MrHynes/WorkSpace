
public class HappynUmber {

	public static boolean getHappyNumber(int number){
		boolean flag=false;
		int num;
		if(number==1) flag= true;
		else{
			int numA=number/10;
			int numB=number%10;
			num=numA*numA+numB*numB;
			flag=getHappyNumber(num);
		}
		return flag;
	}
	public static void main(String[] args) {
		for(int i=1;i<=19;i++){
			if(getHappyNumber(i)){
				System.out.println(i);
			}
		}
		
	}
}
