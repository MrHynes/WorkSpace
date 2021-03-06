package pers.qiqcheng.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.bookstore.factory.DaoFactory;

public class DelBook extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		resp.setContentType("text/html;charset=utf-8");
		String isbn=req.getParameter("isbn");
		HttpSession session=req.getSession();
		String username=(String)session.getAttribute("username");
		String sql="delete from shopcart where isbn=? and username=?";
		String []params={isbn,username};
		Boolean flag=false;
		/**
		 * 单购物车里面只有一件商品的时候，无法删除？？
		 */
		try {
//			PrintWriter out=resp.getWriter();
//			out.print(username);
//			out.println(isbn);
			flag=DaoFactory.getBookDaoInstances().doDelete(sql, params);
			if(flag){
				//req.getRequestDispatcher("shoppingCart.jsp").forward(req, resp);
				resp.sendRedirect("shoppingCart.jsp");
			}else{
				resp.sendRedirect("error.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
