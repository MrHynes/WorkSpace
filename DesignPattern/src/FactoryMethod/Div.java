package FactoryMethod;

public class Div extends COperator {
	public double GetResult(){
		return getNumA()/getNumB();
	}
}
