package 装饰模式;

public class C加奶的饮料 extends C加料的饮料{
	
	public C加奶的饮料(I饮料 饮料) {
		super(饮料);
		// TODO Auto-generated constructor stub
	}
	public String 获取描述(){
		return "奶"+饮料.获取描述();
	}
	public double 计算价格(){
		return 2+饮料.计算价格();
	}
}
