package com.ch03.Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Counter extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session=req.getSession();
		PrintWriter out =resp.getWriter();
		Integer integer=(Integer)session.getAttribute("count");
		if(integer==null){
			integer=new Integer(0);
		}else {
			integer=new Integer(integer.intValue()+1);
		}
		session.setAttribute("count", integer);
		out.print(integer);
	}

}
