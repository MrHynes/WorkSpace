package pers.qiqcheng.ec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.qiqcheng.ec.factory.DaoFactory;

public class RegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String sql="insert into t_user values(?,?,?,?,?,?,?,?,?)";
		String user=req.getParameter("user");
		String pwd=req.getParameter("pwd");
		String pwd2=req.getParameter("pwd2");
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		String birth=req.getParameter("birth");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		String address=req.getParameter("address");
		String code=req.getParameter("code");
		String params[]={user,pwd,name,sex,birth,email,phone,address,code};
		boolean flag=false;
		if(!"".equals(pwd)&&!"".equals(pwd2)){
			if(pwd.equals(pwd2)){
				try {
					flag=DaoFactory.getUserDaoInstances().doInsert(sql, params);
					if(flag){
						req.getRequestDispatcher("regsucc.jsp").forward(req, resp);
					}else {
						resp.sendRedirect("error.jsp");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				resp.sendRedirect("error.jsp");
			}
		}else {
			resp.sendRedirect("error.jsp");
		}
	}

}