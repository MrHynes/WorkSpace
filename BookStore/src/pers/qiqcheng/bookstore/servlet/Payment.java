package pers.qiqcheng.bookstore.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.bookstore.bean.BookBean;
import pers.qiqcheng.bookstore.factory.DaoFactory;

public class Payment extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session=req.getSession();
		String username=(String)session.getAttribute("username");
		if(username==null){
			req.setAttribute("message", "Äú»¹Î´µÇÂ¼£¬ÇëÏÈµÇÂ¼");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
			return;
		}
		String isbn=req.getParameter("isbn");
		String sql="select * from bookinfo where isbn=?";
		String []params={isbn};
		//HttpSession session=req.getSession();
		BookBean paybook=null;
		try {
			ResultSet rs=DaoFactory.getBookDaoInstances().doSelect(sql, params);
			while(rs.next()){
				paybook=new BookBean(rs.getString(1),rs.getFloat(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
			}
			//session.setAttribute("paybook", paybook);
			req.setAttribute("paybook", paybook);
			req.getRequestDispatcher("payment.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
