package FactoryMethod;

public class DivFactory implements IFactoryMethod {

	@Override
	public COperator createOperation() {
		// TODO Auto-generated method stub
		return new Div();
	}

}
