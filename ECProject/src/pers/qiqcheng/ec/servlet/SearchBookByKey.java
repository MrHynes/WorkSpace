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

import pers.qiqcheng.ec.bean.GoodsBean;
import pers.qiqcheng.ec.bean.PageBean;
import pers.qiqcheng.ec.factory.DaoFactory;


public class SearchBookByKey extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		HttpSession session = req.getSession();
		List<GoodsBean> searchGoods = new ArrayList<GoodsBean>();
		GoodsBean goodsBean = null;
		PageBean pageBean=new PageBean();
		int totalRecord=0;
		ResultSet rs=null,rs2=null;
		String sql = "select * from t_goods where goodname like ? or gooddescription like ? limit 0,12";
		String sql2 = "select count(*) as t from t_goods where goodname like ? or gooddescription like ?";
		String[] params = { "%" + key + "%", "%" + key + "%"};
		String[] params2 = { "%" + key + "%", "%" + key + "%" };
		try {
			rs = DaoFactory.getUserDaoInstances().doSelect(sql, params);
			rs2=DaoFactory.getUserDaoInstances().doSelect(sql2, params2);
			while (rs.next()) {
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
				searchGoods.add(goodsBean);
			}
			while(rs2.next()){
				totalRecord=rs2.getInt("t");
			}
			pageBean.setList(searchGoods);
			pageBean.setPageNo(1);
			pageBean.setPageSize(12);
			pageBean.setTotalRecord(totalRecord);
			session.setAttribute("pageBean", pageBean);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
