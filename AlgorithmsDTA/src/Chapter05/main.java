package Chapter05;

public class main {
public static void main(String[] args) {
	Horner horner=new Horner();
	int x=2;
	int n=10;
	int a[]=new int[]{1,1,1,1,1,1,1,1,1,1};
	int p=horner.GetValues(x, n, a);
	System.out.println("horner表达式的值为："+p);
	//求2的10次方
	Exprec exprec=new Exprec();
	int y=exprec.getPower(2, 9);
	System.out.println("2^10="+y);
	
	int count=0;
	int b[]={5,5,1,5,3,5};
	int c=new Candidate().candidate(b, 0);
	for(int i=0;i<b.length;i++){
		if(c==b[i]) count++;
	}
	if(count>b.length/2){
		System.out.println("多数元素是"+c);
	}else {
		System.out.println("不存在多数元素"+c);
	}
	
}
}
