package Chapter06;
//Êı×éÅÅĞòÀà
import java.util.Arrays;

public class SortArray extends Array1 {

	public SortArray(int len) {
		super(len);
		// TODO Auto-generated constructor stub
	}
	public int[] getArray(){
		Arrays.sort(super.getArray());
		return super.getArray();
	}

	
}
