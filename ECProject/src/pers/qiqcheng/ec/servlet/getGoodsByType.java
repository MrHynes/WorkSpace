package pers.qiqcheng.ec.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.ec.bean.GoodsBean;
import pers.qiqcheng.ec.bean.PageBean;
import pers.qiqcheng.ec.factory.DaoFactory;
/**
 * 根据关键字key查询商品
 * @author Buer
 *
 */
public class GetGoodsByType extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * 根据商品类型查询商品
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req获得majorTypeId，typeID
		String majorTypeID=req.getParameter("majorTypeID");
		String typeID=req.getParameter("typeID");
		String sql=new String();
		String sql2=new String();
		String params[]={majorTypeID,typeID};
		PageBean pageBean=new PageBean();
		HttpSession session=req.getSession();
		List<GoodsBean> goodsList=new ArrayList<GoodsBean>();
		GoodsBean goodsBean=null;
		int totalRecord=0;
		//如果majorTypeID为nul说明查询的的是小类
		if(majorTypeID==null){
			sql="select * from t_goods where subclassid=? limit 0,12";
			sql2="select count(*) as t from t_goods where subclassid=?";
			for(int i=1;i<params.length;i++){
				params[i-1]=params[i];
			}
			params = Arrays.copyOf(params, params.length - 1);
			//否则查询大类
		}else{
			sql="select * from t_goods where majorclassid=? limit 0,12";
			sql2="select count(*) as t from t_goods where majorclassid=?";
			params = Arrays.copyOf(params, params.length - 1);
		}
		try {
			ResultSet rs=DaoFactory.getUserDaoInstances().doSelect(sql, params);
			ResultSet rs2=DaoFactory.getUserDaoInstances().doSelect(sql2, params);
			while(rs.next()){
				goodsBean=new GoodsBean();
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
			while(rs2.next()){
				totalRecord=rs2.getInt("t");
			}
			pageBean.setList(goodsList);
			pageBean.setPageNo(1);
			pageBean.setPageSize(12);
			pageBean.setTotalRecord(totalRecord);
			session.setAttribute("pageBean", pageBean);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
