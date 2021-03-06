package pers.qiqcheng.pagesplit.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.qiqcheng.pagesplit.bean.PageBean;
import pers.qiqcheng.pagesplit.bean.Student;
import pers.qiqcheng.pagesplit.factory.DaoFactory;

public class GetStudentServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String sql="select id,name,age,score from mytab limit ?,?";
		String sql2="select count(*) as t from mytab";
		String pageNoStr=req.getParameter("pageNo");
		Student student=null;
		PageBean pageBean=new PageBean();
		int pageNo;
		int pageSize=3;
		int totalRecords=0;
		if(pageNoStr==null){
			pageNo=1;
		}else {
			pageNo=Integer.parseInt(pageNoStr);
		}
		List<Student> list=new ArrayList<Student>();
		int start=(pageNo-1)*pageSize;
		Integer []param={start,pageSize};
		try {
			ResultSet rs=new DaoFactory().getPageSplitDaoInstance().getAll(sql, param);
			while(rs.next()){
				student=new Student();
				student.setId(rs.getString(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				student.setScore(rs.getFloat(4));
				list.add(student);
			}
			String []p={};
			ResultSet rs2=new DaoFactory().getPageSplitDaoInstance().getAll(sql2, p);
			if(rs2.next()){
				totalRecords=rs2.getInt("t");
			}
			pageBean.setList(list);
			pageBean.setTotalRecord(totalRecords);
			pageBean.setPageSize(pageSize);
			pageBean.setPageNo(pageNo);
			req.setAttribute("pageBean", pageBean);
			//req.setAttribute("students", list);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
