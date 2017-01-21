package FactoryMethod;

public class main {
	public static void main(String[] args) {
		//简单工厂方法
//		OperatorFactory of=new OperatorFactory();
//		COperator op=of.createFactory("/");
//		op.setNumA(12);
//		op.setNumB(13);
//		System.out.println(op.GetResult());
		
		//工厂方法模式
		//IFactoryMethod fm=new AddFactory();
		//IFactoryMethod fm=new SubFactory();
		//IFactoryMethod fm=new MultFactory();
		IFactoryMethod fm=new DivFactory();
		COperator op=null;
		op=fm.createOperation();
		op.setNumA(12);
		op.setNumB(13);
		System.out.println(op.GetResult());
	}

}
