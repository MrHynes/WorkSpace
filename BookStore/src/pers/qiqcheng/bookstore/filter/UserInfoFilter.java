package pers.qiqcheng.bookstore.filter;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.bookstore.bean.UserBean;
import pers.qiqcheng.bookstore.factory.DaoFactory;

/**
 * 用户个人信息过滤器
 * 点击userinfo.jsp之前，执行该方法
 * 程序查询数据库中的个人信息表，将数据保存在userbean中
 * 再将userbean保存在session中
 * @author Buer
 *
 */
public class UserInfoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		UserBean userBean=null;
		String username=(String)session.getAttribute("username");
		String sql="select * from userinfo where username=?";
		String []params={username};
		try {
			ResultSet rs=DaoFactory.getBookDaoInstances().doSelect(sql, params);
			while(rs.next()){
				userBean=new UserBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));	
			}
			session.setAttribute("userinfo", userBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		chain.doFilter(req, resp);
	}

}
