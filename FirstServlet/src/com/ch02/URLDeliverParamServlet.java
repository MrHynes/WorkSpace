package com.ch02;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/FirstServlet/urlDeliverParamServlet?name=chengqi&password=123

public class URLDeliverParamServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		PrintWriter out=resp.getWriter();
		out.println("name:"+name);
		out.println("password:"+password);
		out.flush();
		out.close();
	}
}

