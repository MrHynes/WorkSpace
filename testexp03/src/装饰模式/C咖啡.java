package 装饰模式;

public class C咖啡 implements I饮料 {

	@Override
	public String 获取描述() {
		// TODO Auto-generated method stub
		return "纯咖啡";
	}

	@Override
	public double 计算价格() {
		// TODO Auto-generated method stub
		return 10;
	}

}
