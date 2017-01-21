package EasyFactoryMethod;

public class main {
	public static void main(String[] args) {
		Operation operation=null;
		OpertionFactory opertionFactory=new OpertionFactory();
		operation=opertionFactory.createOperation("+");
		operation.setNumberA(12);
		operation.setNumberB(23);
		System.out.println(operation.getResult());
	}
	
}
