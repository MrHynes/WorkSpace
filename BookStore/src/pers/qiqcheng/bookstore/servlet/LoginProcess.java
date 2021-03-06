package pers.qiqcheng.bookstore.servlet;

import pers.qiqcheng.bookstore.factory.DaoFactory;
import pers.qiqcheng.bookstore.tools.MD5Code;

import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginProcess extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		// 将密码转化为MD5码
		String pass = new MD5Code().getMD5ofStr(req.getParameter("password"));
		String sql = "select * from userinfo where username=? and password=?";
		String free = req.getParameter("free");
		String params[] = { username, pass };
		ResultSet rs;
		try {
			rs = DaoFactory.getBookDaoInstances().doSelect(sql, params);
			if (rs.next()) {
				// 如果用户名和密码正确，进入显示商品页面，并将用户名保存在作用域对象中
				session.setAttribute("username", username);
				// 如果登录时，选择了下次自动登录，就把用户信息保存到cookie
				if (free != null) {
					Cookie cookie = new Cookie(username, pass);
					cookie.setMaxAge(60 * 5);// 保存5分钟
					resp.addCookie(cookie);
				}
				req.getRequestDispatcher("pageNo?pageNo=1").forward(req, resp);
				//req.getRequestDispatcher("pageNo?pageNo=0").forward(req, resp);
				//resp.sendRedirect("http://localhost:8080/BookStore/index.jsp");
			} else {
				session.setAttribute("username", username);
				resp.sendRedirect("http://localhost:8080/BookStore/login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
