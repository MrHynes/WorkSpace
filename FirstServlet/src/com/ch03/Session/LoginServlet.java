package com.ch03.Session;

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


public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		HttpSession session=req.getSession();//获取相应的session
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql="select * from usertbl where name=? and password=?";
		try {
			conn=new ConnectionFactory().getConnection();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, password);
			rs=pstm.executeQuery();
			/*
			 * 如果数据库中存在该用户名则将用户名保存在session，跳转到indexServlet
			 * 否则直接跳转到loginServlet中，重新输入用户名和密码
			 */
			if(rs.next()){
				session.setAttribute("name", name);
				req.getRequestDispatcher("sessionindexServlet").forward(req, resp);//重定向和转发
			}
			else{
				req.getRequestDispatcher("/sessionLogin.html").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ResourceClose.close(rs,pstm,conn);
		}
		
	}

}
