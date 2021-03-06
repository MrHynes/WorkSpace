package com.dbop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbop.dao.factory.DaoFactory;
import com.dbop.vo.Info;

public class Insert extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		float score=Float.parseFloat(req.getParameter("score"));
		Info info=new Info(id,name,age,score);
		boolean flag=false;
		try {
			flag=DaoFactory.getIDbopDaoInstance().doInsert(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag){//插入数据成功
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}else{
			resp.sendRedirect("http://localhost:8080/WebAppDBOper/error.jsp");
		}
	}

}
