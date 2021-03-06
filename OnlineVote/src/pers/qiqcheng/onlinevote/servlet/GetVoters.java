package pers.qiqcheng.onlinevote.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.onlinevote.factory.DaoFactory;
import pers.qiqcheng.onlinevote.vo.Votes;

public class GetVoters extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String sql="select id,name,number from voters";
		String[]params={};
		List<Votes> list=new ArrayList<Votes>();
		try {
			list=DaoFactory.getVoteDaoInstance().getVoters(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("voter", list);
		req.getRequestDispatcher("showVotes.jsp").forward(req, resp);
	}

}
