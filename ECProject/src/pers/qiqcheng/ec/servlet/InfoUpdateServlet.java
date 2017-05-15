package pers.qiqcheng.ec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.xmlrpc.base.Params;

import pers.qiqcheng.ec.factory.DaoFactory;

public class InfoUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getContextPath();
		String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()
				+ path + "/";
		resp.setContentType("text/html;charset=utf-8");
		String newuser =req.getParameter("username");
		String relname=req.getParameter("relname");
		String sex=req.getParameter("sex");
		String birthday=req.getParameter("birthday");
		String telephone=req.getParameter("telephone");
		String email=req.getParameter("email");
		String postcode=req.getParameter("postcode");
		String address=req.getParameter("address");
		HttpSession session=req.getSession();
		/*PrintWriter out=resp.getWriter();
		out.print(username+" "+sex+" "+address+" "+birthday); */
		String sql="update t_user set username=?,relname=?,sex=?,birthday=?,telephone=?,email=?,postcode=?,address=? where username=?";
		String username=(String)session.getAttribute("username");
		String params[]={newuser,relname,sex,birthday,telephone,email,postcode,address,username};
		boolean flag=false;
		try {
			flag=DaoFactory.getUserDaoInstances().doUpdate(sql, params);
			if(flag){
				//修改成功
				req.getRequestDispatcher("/getUserInfon").forward(req, resp);
			}else {
				resp.sendRedirect(basePath+"/common/error.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
