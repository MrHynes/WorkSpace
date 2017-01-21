package FactoryMethod;

public class MultFactory implements IFactoryMethod {

	@Override
	public COperator createOperation() {
		// TODO Auto-generated method stub
		return new Mult();
	}

}
