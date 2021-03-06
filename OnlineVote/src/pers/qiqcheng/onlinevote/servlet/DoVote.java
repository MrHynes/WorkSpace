package pers.qiqcheng.onlinevote.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.onlinevote.factory.DaoFactory;

public class DoVote extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String id=req.getParameter("id");
		int num=Integer.parseInt(req.getParameter("num"))+1;
		String sql="update voters set number=+"+num+" where id=?";
		String[] params={id};
		boolean flag=false;
		try {
			flag=DaoFactory.getVoteDaoInstance().doUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag){
			//resp.sendRedirect("http://localhost:8080/OnlineVote/getVoters");
			//req.getRequestDispatcher("getVoters").forward(req, resp);
			req.getRequestDispatcher("voteSuccess.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("http://localhost:8080/OnlineVote/error.jsp");
		}
	}

}
