public class fx_tongpei_up <T extends Number,X>{
	/**
	 * @param args
	 * 上限泛型通配
	 */
	X st;
	T sx;
	public void set(T sx,X st){
		this.st=st;
		this.sx=sx;
	}
	public void get(){
		System.out.println(st);
		System.out.println(sx);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fx_tongpei_up<Integer,String> sth=new fx_tongpei_up<Integer,String>();
		int sx=10;
		String st="string";
		sth.set(sx, st);
		sth.get();
	}
}
