package pers.qiqcheng.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.qiqcheng.bookstore.factory.DaoFactory;

public class InventoryChange extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html;charset=utf-8");
		String isbn=req.getParameter("isbn");
		String params[]={isbn};
		String sql="update bookinfo set inventory=inventory-1 where isbn=?";
		boolean flag=false;
		try {
			flag=DaoFactory.getBookDaoInstances().doUpdate(sql, params);
			if(flag){
				req.setAttribute("message", "����ɹ���");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
//				PrintWriter out=resp.getWriter();
//				out.println("��ȷ");
			}else {
				resp.sendRedirect("error.jsp");
//				PrintWriter out=resp.getWriter();
//				out.println("����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
