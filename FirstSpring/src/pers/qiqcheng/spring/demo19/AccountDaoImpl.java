package pers.qiqcheng.spring.demo19;

import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	/**
	 * ת��
	 * to �õ�Ǯ����
	 */
	@Override
	public void in(String to, Double money) {
		String sql="update account set money=money+? where name=?";
		this.getJdbcTemplate().update(sql,money,to);
	}

	/**
	 * ת��
	 * out ת������
	 */
	@Override
	public void out(String from, Double money) {
		String sql="update account set money=money-? where name=?";
		this.getJdbcTemplate().update(sql,money,from);
		
	}

}
