package pers.qiqcheng.spring.demo15;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDao extends JdbcDaoSupport{

	public void add(User user) {
		String sql="insert into user values(?,?)";
		this.getJdbcTemplate().update(sql,user.getId(),user.getName());
	}

	public void update(User user) {
		String sql="update user set name=? where id=?";
		this.getJdbcTemplate().update(sql,user.getName(),user.getId());
	}

	public void delete(User user) {
		String sql="delete from user where id=?";
		this.getJdbcTemplate().update(sql,user.getId());
	}
	public int findCount(){
		String sql="select count(*) from user";
		return this.getJdbcTemplate().queryForInt(sql);
	}
	public String findNameByID(int id){
		String sql="select name from user where id=?";
		return this.getJdbcTemplate().queryForObject(sql, String.class,id);
	}
	public User findUserByID(int id){
		String sql="select * from user where id=?";
		return this.getJdbcTemplate().queryForObject(sql, new UserRowMapper(),id);
	}
	public List<User> findAll(){
		String sql="select * from user order by id";
		return this.getJdbcTemplate().query(sql, new UserRowMapper());
	}
	//�ڲ���
	class UserRowMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user=new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			return user;
		}
		
	}
}
