package com.ch03.Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println("<html><head><title>session</title></head><body>");
		out.println("SessionID:"+session.getId()+"<br>");//获取session的id
		out.println("Session Attribute:"+session.getAttribute("name")+"<br>");//从session对象中获取name值
		out.println("Session timeout:"+session.getMaxInactiveInterval()+"s"+"<br>");
		session.setMaxInactiveInterval(300);//设置session的过期时间为300s，该设置只对当前session有效
		out.println("Session timeout:"+session.getMaxInactiveInterval()+"s"+"<br>");
		out.println("<a href=\"sessionview1Servlet\">view1</a><br>");
		out.println("<a href=\"sessionview2Servlet\">view2</a><br>");
		out.println("</body></html>");
		out.close();
	}
	

}
