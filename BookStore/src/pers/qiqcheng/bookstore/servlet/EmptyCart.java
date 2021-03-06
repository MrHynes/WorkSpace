package pers.qiqcheng.bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.bookstore.factory.DaoFactory;

public class EmptyCart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String username=(String)session.getAttribute("username");
		String sql="delete from shopcart where username=?";
		String []params={username};
		boolean flag=false;
		try {
			flag=DaoFactory.getBookDaoInstances().doDelete(sql, params);
			if(flag){
				req.setAttribute("message", "已经清空购物车！");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			}else{
				req.setAttribute("message", "购物车已经是空！");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
