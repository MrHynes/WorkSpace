import java.util.Scanner;
public class demo05 {

	/**用 变量with中的字符替换s中出现的odd字符
	 * @param args
	 */
	public static String replace(String s,String odd,String with){
		String myString=s;
		String newString="";
		while(myString.indexOf(odd)>=0&&(!odd.equals(""))){
			int start=myString.indexOf(odd);
			int end=start+odd.length();
			newString+=myString.substring(0,start)+with;
			myString=myString.substring(end,myString.length());
		}
		return newString+myString;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(replace("replace", "pl", "cd"));
		System.out.println(replace("replace", "pl", ""));
		System.out.println(replace("replace", "aa", "cd"));
		System.out.println(replace("replacre", "re", "cd"));
	}

}
