package pers.qiqcheng.spring.demo16;

public interface AccountDao {
	/**
	 * 转入的方法
	 * @param to
	 * @param money
	 */
	public void in(String to,Double money);
	/**
	 * 转出的方法
	 * @param from
	 * @param money
	 */
	public void out(String from,Double money);
}
