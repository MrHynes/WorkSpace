package pers.qiqcheng.ec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.ec.factory.DaoFactory;

public class UpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String sql="update t_user set sname=?,ssex=?,dbirth=?,semail=?,sphone=?,saddress=?,scode=? where suser=?";
		HttpSession session=req.getSession();
		String user=(String)session.getAttribute("user");
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		String birth=req.getParameter("birth");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		String address=req.getParameter("address");
		String code=req.getParameter("code");
		String params[]={name,sex,birth,email,phone,address,code,user};
		boolean flag=false;
		try {
			flag=DaoFactory.getUserDaoInstances().doUpdate(sql, params);
			if(flag){
				req.getRequestDispatcher("updatesucc.jsp").forward(req, resp);;
			}else {
				resp.sendRedirect("error.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}