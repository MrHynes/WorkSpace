package com.ch02.p59;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
		out.println("<html><head><title>登录失败</title></head><body>");
		//如果数据库中不存在输入的用户名，显示“对不起null”,由于客户端重定向的时候，
		//LoginServlet和ErrorServlet不共享request对象，所以使用req.getAttribute不能获取name的值
		out.println("<font size=5 clolr=red>对不起"+req.getAttribute("name")+",登录失败!!!</font>");
		out.println("</body></html>");
		out.close();
	}

}
