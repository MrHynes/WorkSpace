package pers.qiqcheng.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.bookstore.bean.BookBean;
import pers.qiqcheng.bookstore.factory.DaoFactory;

public class SearchBookByKey extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String key = req.getParameter("key");
		HttpSession session = req.getSession();
		List<BookBean> searchBooks = new ArrayList<BookBean>();
		BookBean searchBook = null;
		String sql = "select * from bookinfo where bookname like ? or author like ?";
		String[] params = { "%" + key + "%", "%" + key + "%" };
		PrintWriter out=resp.getWriter();
		//out.print(params[0]+" "+params[1]);
		try {
			ResultSet rs = DaoFactory.getBookDaoInstances().doSelect(sql, params);
			while (rs.next()) {
				searchBook=new BookBean(rs.getString(1),rs.getFloat(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
				searchBooks.add(searchBook);
			}
			session.setAttribute("searchBooks", searchBooks);
			req.getRequestDispatcher("index.jsp?flag=notnull").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
