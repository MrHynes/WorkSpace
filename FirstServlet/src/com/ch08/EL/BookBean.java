package com.ch08.EL;
import com.ch06.JavaBean.Book;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookBean extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book=new Book("103920345", "��JavaWeb������ơ�");
		req.setAttribute("book", book);
		RequestDispatcher dispatcher;
		dispatcher=req.getRequestDispatcher("/JSP/el/getBean.jsp");
		dispatcher.forward(req, resp);
	}
}
