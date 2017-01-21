package 装饰模式;

public class main {
	public static void main(String[] args) {
		I饮料 饮料=new C咖啡();
		饮料=new C加糖的饮料(饮料);
		饮料=new C加奶的饮料(饮料);
		System.out.println(饮料.获取描述()+" "+饮料.计算价格());
	}

}
