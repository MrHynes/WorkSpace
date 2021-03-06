package com.ch03.Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookiesServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=GBK");
		PrintWriter out=resp.getWriter();
		out.println("<html><head><title>getCookies</title></head><body>");
		out.println("<h2>从Cookies读取的用户名和密码");
		Cookie []cookies=req.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("username")){
				out.println("用户名:"+cookie.getValue()+"  ");
			}
			if(cookie.getName().equals("password")){
				out.println("密码:"+cookie.getValue()+"<br>");
			}
		}
		out.println("</body></html>");
		out.flush();
		out.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	

}
