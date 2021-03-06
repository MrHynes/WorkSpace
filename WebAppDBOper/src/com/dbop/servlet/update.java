package com.dbop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbop.dao.factory.DaoFactory;
import com.dbop.vo.Info;

public class update extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		float score=Float.parseFloat(req.getParameter("score"));
		Info info=new Info(id, name, age, score);
		boolean flag=false;
		try {
			flag=DaoFactory.getIDbopDaoInstance().doUpdate(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag){//更新数据成功
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}else{
			resp.sendRedirect("http://localhost:8080/WebAppDBOper/error.jsp");
		}
		/*
		 * 测试代码而已
		PrintWriter out=resp.getWriter();
		out.println(info.getId()+" "+info.getName()+" "+info.getAge()+" "+info.getScore());
		*/
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
