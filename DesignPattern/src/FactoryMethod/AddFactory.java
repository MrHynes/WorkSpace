package FactoryMethod;

public class AddFactory implements IFactoryMethod {

	@Override
	public COperator createOperation() {
		// TODO Auto-generated method stub
		return new Add();
	}

}
