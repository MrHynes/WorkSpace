package Chapter05;

public class main {
public static void main(String[] args) {
	Horner horner=new Horner();
	int x=2;
	int n=10;
	int a[]=new int[]{1,1,1,1,1,1,1,1,1,1};
	int p=horner.GetValues(x, n, a);
	System.out.println("horner����ʽ��ֵΪ��"+p);
	//��2��10�η�
	Exprec exprec=new Exprec();
	int y=exprec.getPower(2, 9);
	System.out.println("2^10="+y);
	
}
}