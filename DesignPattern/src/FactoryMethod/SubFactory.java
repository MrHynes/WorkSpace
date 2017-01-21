package FactoryMethod;

public class SubFactory implements IFactoryMethod {

	@Override
	public COperator createOperation() {
		// TODO Auto-generated method stub
		return new Sub();
	}

}
