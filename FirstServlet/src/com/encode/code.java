package com.encode;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class code extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		//String x=new String(name.getBytes("utf-8"),"ISO-8859-1");
		//String text=URLEncoder.encode(name,"utf-8");
		//String str=URLDecoder.decode(text,"BIG5");
		PrintWriter out=resp.getWriter();//%E6%9E%97
		out.println(name);
		//out.println(x);
		//out.println(text);
		//out.println(str);
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}