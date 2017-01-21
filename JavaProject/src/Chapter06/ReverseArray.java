package Chapter06;

public class ReverseArray extends Array1 {

	public ReverseArray(int len) {
		super(len);
		// TODO Auto-generated constructor stub
	}
	
	public int[] getArray(){
		int a[]=new int[super.getArray().length];
		for(int i=0;i<a.length;i++){
			a[a.length-1-i]=super.getArray()[i];
		}
		return a;
	}

}
