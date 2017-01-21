package TemplateMethod;

public abstract class AbstractClass {
	public abstract void Oper1();
	public abstract void Oper2();
	public void TemplateMethod(){
		Oper1();
		Oper2();
	}
}
