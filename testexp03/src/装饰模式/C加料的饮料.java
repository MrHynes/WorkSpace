package 装饰模式;

public class C加料的饮料 implements I饮料 {

	I饮料 饮料;
	public C加料的饮料(I饮料 饮料) {
		super();
		this.饮料 = 饮料;
	}

	@Override
	public String 获取描述() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double 计算价格() {
		// TODO Auto-generated method stub
		return 0;
	}

}
