package pers.qiqcheng.onlinechat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.onlinechat.factory.DaoFactory;

public class Rename extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String name=req.getParameter("name");
		String rename=req.getParameter("rename");
		HttpSession session=req.getSession();
		/**
		 * 测试： 修改的值是否通过url传过来
		 */
		//PrintWriter out=resp.getWriter();
		//out.print(name+" "+rename);
		String sql="update userinfo set username=? where username=?";
		String []params={rename,name};
		boolean flag=false;
		try {
			flag=DaoFactory.getChatDaoInstance().doUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag){
			session.setAttribute("users", rename);
			req.getRequestDispatcher("chatPage.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("http://localhost:8080/OnlineChatting/error.jsp");
		}
	}

}
