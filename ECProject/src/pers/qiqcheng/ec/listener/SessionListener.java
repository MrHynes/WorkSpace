package pers.qiqcheng.ec.listener;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import pers.qiqcheng.ec.bean.CartBean;
import pers.qiqcheng.ec.bean.CartItemBean;
import pers.qiqcheng.ec.factory.DaoFactory;

public class SessionListener implements HttpSessionListener {
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session=se.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			CartBean cartBean = CartBean.getCartBean(session);
			String sql = "insert into t_cart values(?,?,?)";
			List<CartItemBean> list = cartBean.getItems();
			for (CartItemBean cartItemBean : list) {
				String params[] = { username, cartItemBean.getGoodID(), cartItemBean.getCount() + "" };
				try {
					DaoFactory.getUserDaoInstances().doInsert(sql, params);
					System.out.println("destroy");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
