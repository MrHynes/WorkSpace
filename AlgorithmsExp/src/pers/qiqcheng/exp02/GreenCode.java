package pers.qiqcheng.exp02;

import java.util.Scanner;

public class GreenCode {
	public static String [] getGreenCode(int m){
		String greenCode[]=new String[(int)Math.pow(2, m)];
		if(m==1){
			greenCode[0]="0";
			greenCode[1]="1";
			return greenCode;
		}
		String res[]=getGreenCode(m-1);
		for(int i=0;i<res.length;i++){
			greenCode[i]="0 "+res[i];
			greenCode[greenCode.length-1-i]="1 "+res[i];
		}
		return greenCode;
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n,m;
		String code[]=new String[100];
		n=scanner.nextInt();
		while(n>0){
			m=scanner.nextInt();
			code=getGreenCode(m);
			n--;
			for (String string : code) {
				System.out.println(string);
			}
		}
	}

}
