package pers.qiqcheng.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.bookstore.bean.UserBean;
import pers.qiqcheng.bookstore.factory.DaoFactory;
import pers.qiqcheng.bookstore.tools.MD5Code;

public class SaveModify extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String password2 = req.getParameter("password2");
		String relName = req.getParameter("relName");
		String telNumber = req.getParameter("telNumber");
		String code = req.getParameter("code");
		String address = req.getParameter("address");
		String pass = new MD5Code().getMD5ofStr(password);
		String sql = null;
		String params[] = { username, pass, relName, telNumber, code, address, username };
		boolean flag = false;
		//PrintWriter out = resp.getWriter();
		/*
		 * 1)要判断密码是否有填，如果有，表示修改了密码 2)如果没有填，那么就不需要更新密码 3)同时还要
		 * 判断两次的密码是否相同，如果是就更新密码，如果不是就要提示。
		 */
		if (password.equals("")) {// 没有修改密码
			sql = "update userinfo set username=?,relname=?,phonenumber=?," + "postalcode=?,address=? where username=?";
			for (int i = 1; i < params.length - 1; i++) {
				params[i] = params[i + 1];
			}
			params = Arrays.copyOf(params, params.length - 1);
		} else if (password.equals(password2)) {
			sql = "update userinfo set username=?,password=?,relname=?,phonenumber=?,"
					+ "postalcode=?,address=? where username=?";
		} else {
			// return 两次密码不对,用jquery实现
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}

		try {
			flag = DaoFactory.getBookDaoInstances().doUpdate(sql, params);
			if (flag) {
				// 更新成功
				// out.println("<script>alert('更新成功')</script>");
				//req.getRequestDispatcher("userInfo.jsp").forward(req, resp);
				resp.sendRedirect("updateSuccess.jsp");
			} else {
				// out.println("<script>alert('更新成识别')</script>");
				req.getRequestDispatcher("error.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * for (String string : params) {
		 * 		 out.println(string); 
		 * } 
		 * out.print(sql);
		 */

	}
}
