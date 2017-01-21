package FactoryMethod;

public class OperatorFactory {
	private COperator opp=null;
	public COperator createFactory(String type){
		switch(type){
		case "+": opp=new Add(); break;
		case "-": opp=new Sub();break;
		case "*": opp=new Mult();break;
		case "/": opp=new Div();break;
		}
		return opp;
	}
}
