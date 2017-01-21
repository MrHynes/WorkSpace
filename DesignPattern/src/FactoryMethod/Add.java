package FactoryMethod;

public class Add extends COperator {
	public double GetResult(){
		return getNumA()+getNumB();
	}
}
