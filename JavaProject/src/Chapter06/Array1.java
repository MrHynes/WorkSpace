package Chapter06;

public class Array1 {

	private int temp[];
	private int foot;
	public Array1(int len){
		if(len>0){
			this.temp=new int[len];
		}
		else{
			this.temp=new int [1];
		}
	}
	public boolean add(int i){
		if(this.foot<temp.length){
			this.temp[foot]=i;
			foot++;
			return true;
		}
		else{
			return false;
		}
	}
	public int[] getArray(){
		return this.temp;
	}
}
