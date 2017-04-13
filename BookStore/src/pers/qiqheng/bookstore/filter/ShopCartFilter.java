package pers.qiqheng.bookstore.filter;

import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.Select;

import pers.qiqcheng.bookstore.bean.BookBean;
import pers.qiqcheng.bookstore.factory.DaoFactory;

public class ShopCartFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		String sql="select * from bookinfo,shopcart where bookinfo.isbn=shopcart.isbn and username=?";
		String params[]={username};
		BookBean book=null;
		List<BookBean> cartBooks=new ArrayList<BookBean>();
		try {
			ResultSet  rs=DaoFactory.getBookDaoInstances().doSelect(sql, params);
			while(rs.next())
			{
				book=new BookBean(rs.getString(1),rs.getFloat(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
				cartBooks.add(book);
				//System.out.println(book.getBookName());
			}
			session.setAttribute("cartBooks", cartBooks);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		PrintWriter out=resp.getWriter();
//		for(int i=0;i<cartBooks.size();i++){
//			BookBean bean=cartBooks.get(i);
//			out.println(bean.getAuthor()+" "+bean.getBookName());
//		}
		chain.doFilter(req, resp);
	}
}