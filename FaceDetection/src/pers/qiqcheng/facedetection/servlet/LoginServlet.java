package pers.qiqcheng.facedetection.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.facedetection.factory.DaoFactory;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String sql="select * from userinfo where id=? and password=?";
		String[] params={username,password};
		ResultSet rs=null;
		try {
			rs=DaoFactory.getFaceDetectionDaoInstance().doSelect(sql, params);
			//����û���������ƥ��ɹ�������ϵͳ��ҳ��
			//�����ض��򵽵�¼ҳ��
			if(rs.next()){
				HttpSession session=req.getSession();
				//�û���������session��
				session.setAttribute("username", username);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}else {
				resp.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}