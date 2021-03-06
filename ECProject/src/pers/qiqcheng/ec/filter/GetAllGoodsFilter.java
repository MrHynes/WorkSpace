package pers.qiqcheng.ec.filter;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.ec.bean.GoodsBean;
import pers.qiqcheng.ec.bean.PageBean;
import pers.qiqcheng.ec.factory.DaoFactory;

public class GetAllGoodsFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		List<GoodsBean> goodList=new ArrayList<GoodsBean>();
		String sql="select * from t_goods limit 0,12";
		String sql2="select count(*) as t from t_goods";
		PageBean pageBean=new PageBean();
		int totalRecords=0;
		GoodsBean goodsBean=null;
		String params[]={};
		try {
			//System.out.println("1");
			ResultSet rs=DaoFactory.getUserDaoInstances().doSelect(sql, params);
			ResultSet rs2=DaoFactory.getUserDaoInstances().doSelect(sql2, params);
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
				goodList.add(goodsBean);
			}
			while(rs2.next()){
				totalRecords=rs2.getInt("t");
			}
			pageBean.setList(goodList);
			pageBean.setPageSize(12);
			pageBean.setTotalRecord(totalRecords);
			pageBean.setPageNo(1);
			session.setAttribute("pageBean", pageBean);
			rs.close();
			rs2.close();
			/*for(int i=0;i<goodList.size();i++){
				System.out.println(goodList.get(i).toString());
			}*/
			chain.doFilter(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
