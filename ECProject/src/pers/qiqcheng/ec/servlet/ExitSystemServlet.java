package pers.qiqcheng.ec.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.ec.bean.CartBean;
import pers.qiqcheng.ec.bean.CartItemBean;
import pers.qiqcheng.ec.factory.DaoFactory;

public class ExitSystemServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * 退出系统之前，把购物车中的记录插入数据库，并销毁session
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("session destroy");
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			CartBean cartBean = CartBean.getCartBean(session);
			String sql = "insert into t_cart values(?,?,?)";
			List<CartItemBean> list = cartBean.getItems();
			for (CartItemBean cartItemBean : list) {
				String params[] = { username, cartItemBean.getGoodID(), cartItemBean.getCount() + "" };
				try {
					DaoFactory.getUserDaoInstances().doInsert(sql, params);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		session.invalidate();
		resp.sendRedirect("/ECProject/index.jsp");
	}
}
