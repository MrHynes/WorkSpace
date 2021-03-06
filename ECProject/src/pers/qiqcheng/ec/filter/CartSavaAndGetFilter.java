package pers.qiqcheng.ec.filter;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.ec.bean.CartBean;
import pers.qiqcheng.ec.bean.CartItemBean;
import pers.qiqcheng.ec.factory.DaoFactory;

public class CartSavaAndGetFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			try {
				insertIntoCart(req, resp, username, session);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		chain.doFilter(req, resp);
	}

	// 用户登录系统后，马上将购物车数据插入数据库
	// 3种情况：1）session中的cartBean为空 2）数据库中的购物车表为空 3）都不为空
	public void insertIntoCart(HttpServletRequest req, HttpServletResponse resp, String username, HttpSession session)
			throws Exception {
		CartBean cartBean = CartBean.getCartBean(session);

		List<CartItemBean> items = cartBean.getItems();
		String goodID = null;
		int count = 0;
		float goodPrice = 0.0f;
		String sql = "select * from t_cart where username=? and goodid=?";
		CartItemBean cartItemBean = null;
		for (int i = 0; i < items.size(); i++) {
			cartItemBean = items.get(i);
			goodID = cartItemBean.getGoodID();
			count = cartItemBean.getCount();
			goodPrice = cartItemBean.getGoodPrice();
			String params[] = { username, goodID };
			ResultSet rs = DaoFactory.getUserDaoInstances().doSelect(sql, params);
			if (rs.next()) {
				// 如果购物车中已经存在该商品，则更新商品数量
				String sql2 = "update t_cart set num=num+? where username=? and goodid=?";
				String parmas2[] = { count + "", username, goodID };
				DaoFactory.getUserDaoInstances().doUpdate(sql2, parmas2);
			} else {
				// 否则将商品插入数据库中的购物车表中
				String sql3 = "insert into t_cart values(?,?,?)";
				String parmas3[] = { username, goodID, count + "" };
				DaoFactory.getUserDaoInstances().doInsert(sql3, parmas3);
			}
		}
		items.clear();
		String sql4 = "select t_goods.goodid,goodname,goodprice,num from t_cart,t_goods where t_cart.goodid=t_goods.goodid and username=?";
		String parmas4[] = { username };
		ResultSet rs = DaoFactory.getUserDaoInstances().doSelect(sql4, parmas4);
		while (rs.next()) {
			cartItemBean = new CartItemBean();
			cartItemBean.setGoodID(rs.getString(1));
			cartItemBean.setGoodName(rs.getString(2));
			cartItemBean.setGoodPrice(rs.getFloat(3));
			cartItemBean.setCount(rs.getInt(4));
			cartItemBean.setTotalPrice(rs.getFloat(3) * rs.getInt(4));
			items.add(cartItemBean);
		}
		cartBean.setItems(items);
		session.setAttribute("cartBean", cartBean);
		String sql5 = "delete from t_cart where username=?";
		String parmas5[] = {username};
		DaoFactory.getUserDaoInstances().doDelete(sql5, parmas5);

	}

}
