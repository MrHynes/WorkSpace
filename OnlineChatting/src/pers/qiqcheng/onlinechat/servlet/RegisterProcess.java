package pers.qiqcheng.onlinechat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.regexp.internal.recompile;

import pers.qiqcheng.onlinechat.util.MD5Code;
import pers.qiqcheng.onlinechat.factory.DaoFactory;


public class RegisterProcess extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String username=req.getParameter("rusername");
		String pass=req.getParameter("rpassword");
		String pass2=req.getParameter("rpassword2");
		String sql="insert into userinfo values(?,?)";
		boolean flag=false;
		//判断 username==null,pass==null,pass2==null,pass==pass2,pass=" ".pass2==" ",username==" "
		if(username!=""&&pass!=""&&pass.equals(pass2)){//判断如果两次密码相同或者密码/用户名不为空的时候
			String password = new MD5Code().getMD5ofStr(pass) ;
			//String[]params={username,pass};
			String[]params={username,password};
			try {
				flag=DaoFactory.getChatDaoInstance().doInsert(sql, params);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(flag){
			req.setAttribute("name", username);
			req.getRequestDispatcher("regSuccess.jsp").forward(req, resp);
		}else{
			resp.sendRedirect("http://localhost:8080/OnlineChatting/register.jsp");
		}
	}

}
