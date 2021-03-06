package pers.qiqcheng.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.bookstore.factory.DaoFactory;

public class AddCart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		resp.setContentType("text/html;charset=utf-8");
		HttpSession session=req.getSession();
		String username=(String)session.getAttribute("username");
		if(username==null){
			req.setAttribute("message", "����δ��¼�����ȵ�¼");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}else{
			String isbn=req.getParameter("isbn");
//			PrintWriter out=resp.getWriter();
//			out.print(isbn);
			String sql="select num from shopcart where username=? and isbn=?";
			String sql2="update shopcart set num=num+1 where username=? and isbn=?";
			String sql3="insert into shopcart values(?,?,1)";
			String params[]={username,isbn};
			boolean flag=false;
			try {
				ResultSet rs=DaoFactory.getBookDaoInstances().doSelect(sql, params);
				if(rs.next()){
					flag=DaoFactory.getBookDaoInstances().doUpdate(sql2, params);
				}else {
					flag=DaoFactory.getBookDaoInstances().doInsert(sql3, params);
				}
				if(flag){
					req.setAttribute("message", "���ӹ��ﳵ�ɹ���");
					req.getRequestDispatcher("msg.jsp").forward(req, resp);
				}else {
					resp.sendRedirect("error.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
