package SuperMarketCashier;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		System.out.print("输入促销方法(妇女节，店庆，正常，国庆节):");
		Scanner scanner=new Scanner(System.in);
		String string=scanner.next();
		CTotal cTotal=new CTotal(string);//妇女节，店庆，正常，国庆节
		double result=0,totalMoney=0;
		int credit=0;
		int num=0,i=0;
		System.out.print("输入商品数量:");
		num=scanner.nextInt();
		//存储商品名称和价格
		String []name=new String[num];
		double []money=new double[num];
		boolean []flag=new boolean[num];
		//输入商品名称和价格
		while(i<num){
			System.out.print("输入商品名称:");
			name[i]=scanner.next();
			System.out.print("输入商品价格:");
			money[i]=scanner.nextDouble();
			if("妇女节".equals(string)){
				System.out.print("是否是妇女产品?(1.true 2.false)");
				flag[i]=scanner.nextBoolean();
			}
			++i;
		}
		//输出所有的商品
		double extraMoney=0;
		for(int j=0;j<num;j++){
			if("妇女节".equals(string)){
				if(flag[j]==true){//是妇女产品
					totalMoney+=money[j];
				}else{
					extraMoney+=money[j];
				}
			}else{
				totalMoney+=money[j];
			}
			System.out.println("商购买的商品名称:"+name[j]+";单价:"+money[j]);
		}
		//计算总价和总积分
		if("妇女节".equals(string)){
			result=cTotal.getTotalMoney(totalMoney)+extraMoney;
			credit=cTotal.getCredit(totalMoney+extraMoney);
		}else{
			result=cTotal.getTotalMoney(totalMoney);
			credit=cTotal.getCredit(totalMoney);
		}
		System.out.println("总价:"+result+";积分:"+credit+";");
	}
}
