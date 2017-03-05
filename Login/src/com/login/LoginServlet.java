package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String mid=req.getParameter("mid");
		//String password =req.getParameter("password");
		//�洢�����ݿ��е���������md5����ܡ������û���������룬��Ҫ��ת����md5����ʽ��Ȼ������ݿ��е�����ƥ�䡣
		String password = new MD5Code().getMD5ofStr(req.getParameter("password")+"{"+mid+"}") ;
		Connection conn = null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql="select * from member where mid=? and password=?";
		try {
			conn=DBConnection.getConnection();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, mid);
			pstm.setString(2, password);
			rs=pstm.executeQuery();
			if(rs.next()){//�����¼�ɹ���ת����success.jspҳ��
				req.setAttribute("mid", mid);
				req.getRequestDispatcher("success.jsp").forward(req, resp);
			}else{//���ʧ�ܣ����ض���errorҳ��
				req.setAttribute("mid", mid);
				resp.sendRedirect("http://localhost:8080/Login/error.jsp");
			}
		}catch (Exception e) {
			e.printStackTrace();
			}
		finally {
		}
	}
}