class text<T>{
		T str;
		T get(){
			return str;
		}
		void set(T str){
			this.str=str;
		}
	}
public class fxClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		text<String> ts=new text<String>();
		ts.set("Java");
		System.out.println(ts.get());
		text<Integer> ts2=new text<Integer>();
		ts2.set(1234);
		System.out.println(ts2.get());
	}
}
