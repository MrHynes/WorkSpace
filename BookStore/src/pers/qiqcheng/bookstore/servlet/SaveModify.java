package pers.qiqcheng.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.bookstore.bean.UserBean;
import pers.qiqcheng.bookstore.factory.DaoFactory;
import pers.qiqcheng.bookstore.tools.MD5Code;

public class SaveModify extends HttpServlet {

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
		String password2=req.getParameter("password2");
		String relName=req.getParameter("relName");
		String telNumber=req.getParameter("telNumber");
		String code=req.getParameter("code");
		String address=req.getParameter("address");
		String pass=null;
		if(password.equals(password2)){
			 pass = new MD5Code().getMD5ofStr(password);
		}else{
			resp.sendRedirect("http://localhost:8080/BookStore/error.jsp");
			return;
		}
//		PrintWriter out=resp.getWriter();
//		out.print(username+""+password+" "+relName+" "+code+" "+address+" "+telNumber);
		//HttpSession session=req.getSession();
		//UserBean userBean=(UserBean) session.getAttribute("userinfo");
		//String sql="update userinfo set username=?,password=?,relname=?,phonenumber=?,postalcode=?,address=? where username=?";
		//String []params={username,pass,relName,telNumber,code,address,"test",username};//������Ҫע��
		/*try {
			DaoFactory.getBookDaoInstances().doUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}
}
