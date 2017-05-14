package pers.qiqcheng.ec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.qiqcheng.ec.factory.DaoFactory;
import pers.qiqcheng.ec.tools.MD5Code;

public class UserRegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getContextPath();
		String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()
				+ path + "/";
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String username =req.getParameter("username");
		String pass =req.getParameter("password");
		String relname=req.getParameter("relname");
		String sex=req.getParameter("sex");
		String birthday=req.getParameter("birthday");
		String telephone=req.getParameter("telephone");
		String email=req.getParameter("email");
		String postcode=req.getParameter("postcode");
		String address=req.getParameter("address");
		String password=new MD5Code().getMD5ofStr(pass);
		String status="0";
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String joindate=sim.format(date);
		boolean flag=false;
		String params[]={username,password,relname,sex,birthday,telephone,email,postcode,address,status,joindate};
		String sql="insert into t_user (username,password,relname,sex,birthday,telephone,email,postcode,address,status,joindate) values"
				+ "(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			flag=DaoFactory.getUserDaoInstances().doInsert(sql, params);
			if(flag){
				req.setAttribute("registername", username);
				req.getRequestDispatcher("/common/regSuccess.jsp").forward(req, resp);
			}else {
				resp.sendRedirect(basePath+"/common/error.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
