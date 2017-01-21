package com.ch02.p59;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;setchar=UTF-8");
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		String sql="select * from usertbl where name=? and password=?";
		try {
			conn=ConnectionFactory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()){
				//如果存在，请求转发
				req.setAttribute("name", name);//将name信息保存在request对象中
				req.getRequestDispatcher("successServlet").forward(req, resp);
			}else{
				//如果不匹配，请求重定向
				req.setAttribute("name", name);
				resp.sendRedirect("http://localhost:8080/FirstServlet/errorServlet");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ResourceClose.close(rs, pstmt, conn);
		}
	}

}
