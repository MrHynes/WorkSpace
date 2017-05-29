package pers.qiqcheng.spring.demo19;

public interface AccountDao {
	/**
	 * ת��ķ���
	 * @param to
	 * @param money
	 */
	public void in(String to,Double money);
	/**
	 * ת���ķ���
	 * @param from
	 * @param money
	 */
	public void out(String from,Double money);
}
