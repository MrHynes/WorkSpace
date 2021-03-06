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
import pers.qiqcheng.bookstore.bean.PageBean;
import pers.qiqcheng.bookstore.factory.DaoFactory;
/**
 * 商品显示过滤器
 * 进入主页（index）前，执行该过滤器
 * 将数据库中的所有商品查询，保存在list集合中。
 * 然后将所有信息保存到pagebean中
 * 实现分页
 * @author Buer
 *
 */
public class ShowBookFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		List<BookBean> books=new ArrayList<BookBean>();
		String sql="select * from bookinfo limit 0,12";
		String sql2="select count(*) as t from bookinfo";
		String []params={};
		ResultSet rs=null,rs2=null;
		BookBean book=null;
		PageBean pageBean=new PageBean();
		int totalRecord=0;
		try {
			rs=DaoFactory.getBookDaoInstances().doSelect(sql, params);
			rs2=DaoFactory.getBookDaoInstances().doSelect(sql2, params);
			while(rs.next()){
				book=new BookBean(rs.getString(1),rs.getFloat(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
				books.add(book);
			}
			//t：数据库中商品总数
			while(rs2.next())
			{
				totalRecord=rs2.getInt("t");
			}
			//session.setAttribute("books", books);
			pageBean.setList(books);
			pageBean.setPageNo(1);
			pageBean.setPageSize(12);
			pageBean.setTotalRecord(totalRecord);
			session.setAttribute("pageBean", pageBean);
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		chain.doFilter(req, resp);
	}
	
}
