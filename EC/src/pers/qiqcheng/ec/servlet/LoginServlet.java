package pers.qiqcheng.ec.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.ec.factory.DaoFactory;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String user=req.getParameter("user");
		String pwd=req.getParameter("pwd");
		String sql="select * from t_user where suser=? and spwd=?";
		HttpSession session=req.getSession();
		String []params={user,pwd};
		try {
			ResultSet rs=DaoFactory.getUserDaoInstances().doSelect(sql, params);
			while(rs.next()){
				session.setAttribute("user", user);
				//req.getRequestDispatcher("index.jsp").forward(req, resp);
				resp.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}