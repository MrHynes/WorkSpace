package com.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetInitParamServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取初始化参数
		String name=this.getInitParameter("name");
		String password=this.getInitParameter("password");
		String  x=this.getServletConfig().getInitParameter("password");
		//获得配置文件中设置Servlet的名字
		String servletName=this.getServletName();
		//如果下面一行注释了，那么读取的参数，会显示乱码
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
		out.println("<html><head><title>getInitParmaServlet</title></head><body>ServletNmae="+servletName+"<br>name="+name+"<br>password="+password+"<br>"+x+"</body></html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	

}
