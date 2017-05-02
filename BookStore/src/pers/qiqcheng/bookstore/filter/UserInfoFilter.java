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
 * �û�������Ϣ������
 * ���userinfo.jsp֮ǰ��ִ�и÷���
 * �����ѯ���ݿ��еĸ�����Ϣ���������ݱ�����userbean��
 * �ٽ�userbean������session��
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