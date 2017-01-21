package com.ch03.Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookiesServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=GBK");
		String username=req.getParameter("username");
		String password=req.getParameter("qpassword");
		PrintWriter out=resp.getWriter();
		String responseContent;
		if(username!=null&&!username.equals("")){
			Cookie c1=new Cookie("username", username);
			Cookie c2=new Cookie("password",password);
			//本程序cookie中不行存储逗号空格，否则会报错。也不可以存储中文，会乱码。
			c1.setMaxAge(60*60);
			c2.setMaxAge(60*60);
			resp.addCookie(c1);
			resp.addCookie(c2);
			responseContent="本次登录的用户名和密码已经成功写入Cookie.<br><a href='/FirstServlet/getCookiesServlet'>读取Cookies信息</a>";		
		}else{
			responseContent="用户名为空，请重新输入.<br><a href='/FirstServlet/input.html'>重新输入</a>";
		}
		out.println("<html><head><title>setCookies</title></head><body>");
		out.println("<h2><font color=red>"+responseContent+"</font></h2>");
		out.println("</body></html>");
		out.flush();
		out.close();
	}
}
