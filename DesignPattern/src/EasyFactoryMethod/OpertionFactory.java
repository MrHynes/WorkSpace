package EasyFactoryMethod;
//π§≥ß¿‡
public class OpertionFactory {
	public Operation createOperation(String op){
		Operation operation=null;
		switch(op){
		case "+": operation=new OperationAdd();break;
		case "-": operation=new OpertionSub();break;
		case "*": operation=new OpertionMult();break;
		case "/": operation=new OpertionDiv();break;
		default:break;
		}
		return operation;
	}

}
