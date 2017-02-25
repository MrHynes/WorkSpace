package com.ch08.EL;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List department=new ArrayList();
		department.add("�����ϵ");
		department.add("����ϵ");
		department.add("��ѧϵ");
		department.add("����ϵ");
		req.setAttribute("departments", department);
		RequestDispatcher dispatcher;
		dispatcher=req.getRequestDispatcher("/JSP/el/getList.jsp");
		dispatcher.forward(req, resp);
	}
}