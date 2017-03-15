package com.dbop.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbop.dao.factory.DaoFactory;
import com.dbop.util.PageBean;
import com.dbop.vo.Info;

public class show extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNo,start;
		List<Info> list=new ArrayList<Info>();
		PageBean pg=new PageBean();
		pg.setPageSize(10);
		String action=req.getParameter("action");
		if("pager".equals(action)){
			String pageNoStr=req.getParameter("pageNo");
			if(pageNoStr==null){
				pageNo=1;
			}else{
				pageNo=Integer.parseInt(pageNoStr);
			}
			pg.setPageNo(pageNo);
			start=(pageNo-1)*pg.getPageSize();
			String sql="select * from info limit "+start+","+pg.getPageSize();
			ResultSet rs=null;
			try {
				rs = DaoFactory.getIDbopDaoInstance().doSelect(sql);
				while(rs.next()){
					Info info=new Info();
					info.setId(rs.getString(1));
					info.setName(rs.getString(2));
					info.setAge(rs.getInt(3));
					info.setScore(rs.getFloat(4));
					list.add(info);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pg.setList(list);
			String sql2="select count(*) as t from info";
			try {
				rs= DaoFactory.getIDbopDaoInstance().doSelect(sql2);
				while(rs.next()){
					pg.setTotalRecords(rs.getInt("t"));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getSession().setAttribute("pg", pg);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
	}
	

}
