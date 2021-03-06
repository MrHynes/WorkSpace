package pers.qiqcheng.spring.demo16;

import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	/**
	 * 转入
	 * to 得到钱的人
	 */
	@Override
	public void in(String to, Double money) {
		String sql="update account set money=money+? where name=?";
		this.getJdbcTemplate().update(sql,money,to);
	}

	/**
	 * 转出
	 * out 转出的人
	 */
	@Override
	public void out(String from, Double money) {
		String sql="update account set money=money-? where name=?";
		this.getJdbcTemplate().update(sql,money,from);
		
	}

}
