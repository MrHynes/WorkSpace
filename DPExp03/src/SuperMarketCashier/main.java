package SuperMarketCashier;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		System.out.print("�����������(��Ů�ڣ����죬�����������):");
		Scanner scanner=new Scanner(System.in);
		String string=scanner.next();
		CTotal cTotal=new CTotal(string);//��Ů�ڣ����죬�����������
		double result=0,totalMoney=0;
		int credit=0;
		int num=0,i=0;
		System.out.print("������Ʒ����:");
		num=scanner.nextInt();
		//�洢��Ʒ���ƺͼ۸�
		String []name=new String[num];
		double []money=new double[num];
		boolean []flag=new boolean[num];
		//������Ʒ���ƺͼ۸�
		while(i<num){
			System.out.print("������Ʒ����:");
			name[i]=scanner.next();
			System.out.print("������Ʒ�۸�:");
			money[i]=scanner.nextDouble();
			if("��Ů��".equals(string)){
				System.out.print("�Ƿ��Ǹ�Ů��Ʒ?(1.true 2.false)");
				flag[i]=scanner.nextBoolean();
			}
			++i;
		}
		//������е���Ʒ
		double extraMoney=0;
		for(int j=0;j<num;j++){
			if("��Ů��".equals(string)){
				if(flag[j]==true){//�Ǹ�Ů��Ʒ
					totalMoney+=money[j];
				}else{
					extraMoney+=money[j];
				}
			}else{
				totalMoney+=money[j];
			}
			System.out.println("�̹������Ʒ����:"+name[j]+";����:"+money[j]);
		}
		//�����ܼۺ��ܻ���
		if("��Ů��".equals(string)){
			result=cTotal.getTotalMoney(totalMoney)+extraMoney;
			credit=cTotal.getCredit(totalMoney+extraMoney);
		}else{
			result=cTotal.getTotalMoney(totalMoney);
			credit=cTotal.getCredit(totalMoney);
		}
		System.out.println("�ܼ�:"+result+";����:"+credit+";");
	}
}
