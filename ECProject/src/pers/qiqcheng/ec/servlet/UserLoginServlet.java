package pers.qiqcheng.ec.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.ec.factory.DaoFactory;
import pers.qiqcheng.ec.tools.MD5Code;

public class UserLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getContextPath();
		String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()
				+ path + "/";
		String username=req.getParameter("username");
		String pass=req.getParameter("password");
		String password=new MD5Code().getMD5ofStr(pass);
		String sql="select * from t_user where username=? and password=?";
		String params[]={username,password};
		HttpSession session=req.getSession();
		try {
			ResultSet rs=DaoFactory.getUserDaoInstances().doSelect(sql, params);
			while(rs.next()){
				session.setAttribute("username", username);
				String sql2="update t_user set logintime=? where username=?";
				SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date=new Date();
				String loginTime=sim.format(date);
				String []params2={loginTime,username};
				DaoFactory.getUserDaoInstances().doUpdate(sql2, params2);
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect(basePath+"common/error.jsp");
		
	}
}
