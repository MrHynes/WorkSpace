package pers.qiqcheng.ec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.qiqcheng.ec.factory.DaoFactory;

public class UserNameIsExist extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * 注册时，判断注册的帐号是否已经存在了，如果不存在则允许新用户注册，否则不允许
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("username");
		PrintWriter out=resp.getWriter();
		if("".equals(user)||user.length()<6||user.length()>10){
			out.print("false");
		}
        String sql="select * from t_user where username=?";
        String params[]={user};
        try {
			ResultSet rs=DaoFactory.getUserDaoInstances().doSelect(sql, params);
			while(rs.next()){
				out.print("false");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        out.print("true");
	}
}
