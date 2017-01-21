package com.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		String name=req.getParameter("name");//获取客户端提交的数据-姓名
		String password=req.getParameter("password");//密码
		String qpassword=req.getParameter("qpassword");
		String sex=req.getParameter("sex");//性别
		String []hobby=req.getParameterValues("hobby");//爱好
		String province=req.getParameter("province");//省份
		String introduuce=req.getParameter("introduce");//简介
		PrintWriter out=resp.getWriter();
		//判断两次输入的密码是否一样
		if(!password.equals(qpassword)){
			out.println("<html><head><title>error!</title></head><body><h1>两次输入的密码不一致，请重新输入!!</h1></body></html>");
		}
		else {
			out.println("<html>");
			out.println("<head><title>RegisterInfo</title></head>");
			out.println("<body><h1>个人详细信息如下:<br>");
			out.println("姓名:"+name+"<br>");
			out.println("密码:"+password+"<br>");
			out.println("确认密码:"+qpassword+"<br>");
			out.println("性别:"+sex+"<br>");
			out.println("爱好:");
			for (String string : hobby) {
				out.println(string+" ");
			}
			out.println("<br>");
			out.println("省份:"+province+"</br>");
			out.println("简介"+introduuce+"<br>");
			out.println("</h1></body></html>");
		}
		out.close();
	}
}
