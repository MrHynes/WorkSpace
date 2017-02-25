package com.ch08.EL;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ch06.JavaBean.Book;
public class ArrayServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book books[]=new Book[4];
		books[0]=new Book("001","��Java����ʵս���䡷");
		books[1]=new Book("002", "��JavaWeb����ָ�ϡ�");
		books[2]=new Book("003", "������ϵͳ��");
		books[3]=new Book("004","����������硷");
		req.setAttribute("books", books);
		RequestDispatcher dispatcher;
		dispatcher=req.getRequestDispatcher("/JSP/el/getArray.jsp");
		dispatcher.forward(req, resp);
	}

	
}