package pers.qiqcheng.ec.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import pers.qiqcheng.ec.bean.PageBean;
import pers.qiqcheng.ec.factory.DaoFactory;
import pers.qiqcheng.ec.bean.GoodsBean;

public class GetPageNo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNo=Integer.parseInt(req.getParameter("pageNo"));//一开始登录后，默认是0
		int pageSize=12;
		int totalRecord=0;
		int start=pageSize*(pageNo-1);
		GoodsBean goodsBean=null;
		List<GoodsBean> goodsList=new ArrayList<GoodsBean>();
		HttpSession session=req.getSession();
		PageBean pageBean=new PageBean();
		String sql="select count(*) as t from t_goods";
		String sql2="select * from t_goods limit ?,?";//第一个?  0开始，第二个问号表示 长度
		ResultSet rs=null,rs2=null;
		String[] params={};
		Integer []params2={start,pageSize};
		try {
			rs2=DaoFactory.getUserDaoInstances().doSelect(sql, params);
			rs=DaoFactory.getUserDaoInstances().doSelect(sql2, params2);
			while(rs2.next()){
				totalRecord=rs2.getInt("t");
			}
			while(rs.next()){
				goodsBean=new GoodsBean();
				goodsBean.setGoodId(rs.getString(1));
				goodsBean.setMajorClassID(rs.getInt(2));
				goodsBean.setSubClassID(rs.getInt(3));
				goodsBean.setGoodName(rs.getString(4));
				goodsBean.setGoodPrice(rs.getFloat(5));
				goodsBean.setGoodDescription(rs.getString(6));
				goodsBean.setGoodImage(rs.getString(7));
				goodsBean.setAddTime(rs.getDate(8));
				goodsBean.setInventory(rs.getInt(9));
				goodsList.add(goodsBean);
			}
			pageBean.setList(goodsList);
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
