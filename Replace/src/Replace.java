import java.util.Scanner;
/**
 * ºãÉú±ÊÊÔ
 * @author Buer
 *
 */
public class Replace {
	public static String replace(String str,char src,char dest){
		char c[]=str.toCharArray();
		for(int i=0;i<str.length();i++){
			if(c[i]==src){
				c[i]=dest;
			}
		}
		String[] newStr=new String(c).split("@");
		StringBuffer stringBuffer=new StringBuffer();
		for (String string : newStr) {
			stringBuffer.append(string);
		}
		return stringBuffer.toString();
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String string=scanner.nextLine();
		char src=scanner.nextLine().charAt(0);
		char dest=scanner.nextLine().charAt(0);
		System.out.println(replace(string, src,dest));
	}

}
