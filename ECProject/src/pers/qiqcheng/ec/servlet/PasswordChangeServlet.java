package pers.qiqcheng.ec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xpath.internal.operations.Bool;

import pers.qiqcheng.ec.factory.DaoFactory;
import pers.qiqcheng.ec.tools.MD5Code;

public class PasswordChangeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getContextPath();
		String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()
				+ path + "/";
		String oldPwd=req.getParameter("oldpassword");
		String newPwd=req.getParameter("password") ;
		/*PrintWriter out=resp.getWriter();
		out.println(oldPwd+" "+newPwd);*/
		String pwd=new MD5Code().getMD5ofStr(newPwd);
		if(!oldPwd.equals(newPwd)){
			HttpSession session=req.getSession();
			String userName=(String)session.getAttribute("username");
			String sql="update t_user set password=? where username=?";
			String params[]={pwd,userName};
			boolean flag=false;
			try {
				flag=DaoFactory.getUserDaoInstances().doUpdate(sql, params);
				if(flag){
					//更新成功,重新登入
					req.getRequestDispatcher("/common/exit.jsp").forward(req, resp);
				}else {
					resp.sendRedirect(basePath+"common/error.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
