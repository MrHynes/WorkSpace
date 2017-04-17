package pers.qiqcheng.bookstore.filter;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.bookstore.bean.BookBean;
import pers.qiqcheng.bookstore.factory.DaoFactory;

public class ShowBookFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		List<BookBean> books=new ArrayList<BookBean>();
		String sql="select * from bookinfo";
		String []params={};
		ResultSet rs=null;
		BookBean book=null;
		try {
			rs=DaoFactory.getBookDaoInstances().doSelect(sql, params);
			while(rs.next()){
				book=new BookBean(rs.getString(1),rs.getFloat(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
				books.add(book);
			}
			session.setAttribute("books", books);
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		chain.doFilter(req, resp);
	}
	
}