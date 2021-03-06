package pers.qiqcheng.ec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.ec.bean.UserBean;
import pers.qiqcheng.ec.factory.DaoFactory;

public class GetUserInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String path = req.getContextPath();
		String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()
				+ path + "/";
		String sql="select * from t_user where username=?";
		HttpSession session=req.getSession();
		String username=(String)session.getAttribute("username");
		String params[]={username};
		UserBean userBean=null;
		try {
			ResultSet rs=DaoFactory.getUserDaoInstances().doSelect(sql, params);
			while(rs.next()){
				userBean=new UserBean();
				userBean.setUserName(rs.getString(1));
				userBean.setPassWord(rs.getString(2));
				userBean.setRelName(rs.getString(3));
				userBean.setSex(rs.getString(4));
				userBean.setBirthDay(rs.getDate(5));
				userBean.setTelePhone(rs.getString(6));
				userBean.setEmail(rs.getString(7));
				userBean.setPostCode(rs.getString(8));
				userBean.setAddress(rs.getString(9));
				session.setAttribute("userbean", userBean);
				//在页面直接输出，测试查询的数据是否正确
				/*PrintWriter out=resp.getWriter();
				out.println(userBean.toString());*/
				req.getRequestDispatcher("/frontend/myinfo.jsp").forward(req, resp);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect(basePath+"common/error.jsp");
	}
}
