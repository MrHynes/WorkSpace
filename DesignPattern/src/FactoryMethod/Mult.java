package FactoryMethod;

public class Mult extends COperator {
	public double GetResult(){
		return getNumA()*getNumB();
	}
}
