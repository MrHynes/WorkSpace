package pers.qiqcheng.onlinevote.servlet;
import pers.qiqcheng.onlinevote.factory.DaoFactory;
import pers.qiqcheng.onlinevote.util.MD5Code;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginProcess extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String username=req.getParameter("username");
		//将密码转化为MD5码
		//String pass = new MD5Code().getMD5ofStr(req.getParameter("password")+"{"+username+"}") ;
		String pass=req.getParameter("password");
		String sql="select * from userinfo where username=? and password=?";
		String params[]={username,pass};
		ResultSet rs;
		try {
			rs = DaoFactory.getVoteDaoInstance().doSelect(sql, params);
			if(rs.next()){
				//如果用户名和密码正确，进入显示投票的页面，并将用户名保存在作用域对象中
				HttpSession session=req.getSession();
				session.setAttribute("users", username);
				req.getRequestDispatcher("getVoters").forward(req, resp);
			}else {
				HttpSession session=req.getSession();
				session.setAttribute("users", username);
				resp.sendRedirect("http://localhost:8080/OnlineVote/login.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
