package pers.qiqcheng.ec.filter;

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

import pers.qiqcheng.ec.bean.UserBean;
import pers.qiqcheng.ec.factory.DaoFactory;

public class UserFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		String user=(String)session.getAttribute("user");
		String sql="select * from t_user where suser=?";
		String params[]={user};
		UserBean userBean=null;
		ResultSet rs;
		try {
			rs = DaoFactory.getUserDaoInstances().doSelect(sql, params);
			while(rs.next()){
				userBean=new UserBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
			session.setAttribute("userBean", userBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chain.doFilter(req, resp);
	}

}
