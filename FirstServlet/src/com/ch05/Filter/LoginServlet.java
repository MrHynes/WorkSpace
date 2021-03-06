package com.ch05.Filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ch02.p59.ConnectionFactory;
import com.ch02.p59.ResourceClose;

public class LoginServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		req.setCharacterEncoding("utf-8"); 
		resp.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		HttpSession session=req.getSession();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Connection conn=null;
		String sql="select * from usertbl where name=? and password=?";
		try {
			conn=ConnectionFactory.getConnection();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, password);
			rs=pstm.executeQuery();
			if(rs.next()){
				session.setAttribute("name", name);
				session.setAttribute("message","恭喜你，登录成功！");
				resp.sendRedirect("http://localhost:8080/FirstServlet/JSP/filter0501/index.jsp");
			}else {
				session.setAttribute("message", "对不起，登录信息有误，请重新登录！");
				req.getRequestDispatcher("/JSP/filter0501/login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ResourceClose.close(rs,pstm,conn);
		}	
	}
}
