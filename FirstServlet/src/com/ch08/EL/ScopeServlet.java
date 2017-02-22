package com.ch08.EL;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScopeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String attr1="hello EL!";
		RequestDispatcher dispatcher;
		req.setAttribute("attr1", attr1);
		dispatcher=req.getRequestDispatcher("/JSP/el/getVar.jsp");
		dispatcher.forward(req, resp);
	}
}
