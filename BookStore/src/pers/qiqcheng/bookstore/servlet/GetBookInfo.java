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

import pers.qiqcheng.bookstore.bean.BookBean;
import pers.qiqcheng.bookstore.bean.PageBean;
import pers.qiqcheng.bookstore.factory.DaoFactory;

public class GetBookInfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		resp.setContentType("text.html;charset=utf-8");
		String pageNoStr=(String)req.getParameter("pageNo");
		String sql="select count(*) as t from bookinfo;";
		String sql2="select * from bookinfo limit ?,?";
		PageBean pageBean=new PageBean();
		BookBean bookBean=null;
		int pageSize=12;
		int pageNo=0;
		int totalRecords=0;
		if(pageNoStr==null){
			pageNo=1;
		}else{
			pageNo=Integer.parseInt(pageNoStr);
		}
		List<BookBean> books=new ArrayList<BookBean>();
		int start=(pageNo-1)*pageSize;
		Integer []params={start,pageSize};
		try {
			ResultSet rs=DaoFactory.getBookDaoInstances().doSelect(sql2, params);
			while(rs.next()){
				bookBean=new BookBean(rs.getString(1), rs.getFloat(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
				books.add(bookBean);
			}
			String param[]={};
			rs=DaoFactory.getBookDaoInstances().doSelect(sql, param);
			while(rs.next()){
				totalRecords=rs.getInt("t");
			}
			pageBean.setList(books);
			pageBean.setTotalRecord(totalRecords);
			pageBean.setPageNo(pageNo);
			pageBean.setPageSize(pageSize);
			HttpSession session=req.getSession();
			session.setAttribute("pageBean", pageBean);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
