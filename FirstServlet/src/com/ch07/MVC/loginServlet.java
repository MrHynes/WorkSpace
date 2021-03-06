package com.ch07.MVC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		DBMySQL dbMySQL=new DBMySQL();
		User user=dbMySQL.login(name, password);
		if(user!=null){
			session.setAttribute("user", user);
			resp.sendRedirect("/FirstServlet/JSP/mvc/success.jsp");
		}else{
			session.setAttribute("message", "登录信息有误，请重新登录！！");
			resp.sendRedirect("/FirstServlet/JSP/mvc/login.jsp");
		}
	}
}
