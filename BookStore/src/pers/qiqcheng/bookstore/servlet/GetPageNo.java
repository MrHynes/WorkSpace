package pers.qiqcheng.bookstore.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.xmlrpc.base.Array;

import pers.qiqcheng.bookstore.bean.BookBean;
import pers.qiqcheng.bookstore.bean.PageBean;
import pers.qiqcheng.bookstore.factory.DaoFactory;

public class GetPageNo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		resp.setContentType("text/html;charset=utf-8");
		int pageNo=Integer.parseInt(req.getParameter("pageNo"));//一开始登录后，默认是0
		int pageSize=12;
		int totalRecord=0;
		int start=pageSize*(pageNo-1);
		BookBean book=null;
		List<BookBean> books=new ArrayList<BookBean>();
		HttpSession session=req.getSession();
		PageBean pageBean=new PageBean();
		String sql="select count(*) as t from bookinfo";
		String sql2="select * from bookinfo limit ?,?";//第一个?  0开始，第二个问号表示 长度
		ResultSet rs=null,rs2=null;
		String[] params={};
		Integer []params2={start,pageSize};
		try {
			rs=DaoFactory.getBookDaoInstances().doSelect(sql, params);
			rs2=DaoFactory.getBookDaoInstances().doSelect(sql2, params2);
			while(rs.next()){
				totalRecord=rs.getInt("t");
			}
			while(rs2.next()){
				book=new BookBean(rs2.getString(1), rs2.getFloat(2), rs2.getString(3), rs2.getString(4), rs2.getString(5), rs2.getInt(6));
				books.add(book);
			}
			pageBean.setList(books);
			pageBean.setPageNo(pageNo);
			pageBean.setPageSize(pageSize);
			pageBean.setTotalRecord(totalRecord);
			session.setAttribute("pageBean", pageBean);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
