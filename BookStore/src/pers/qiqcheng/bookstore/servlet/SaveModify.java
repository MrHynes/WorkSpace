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
		 * 1)Ҫ�ж������Ƿ��������У���ʾ�޸������� 2)���û�����ô�Ͳ���Ҫ�������� 3)ͬʱ��Ҫ
		 * �ж����ε������Ƿ���ͬ������Ǿ͸������룬������Ǿ�Ҫ��ʾ��
		 */
		if (password.equals("")) {// û���޸�����
			sql = "update userinfo set username=?,relname=?,phonenumber=?," + "postalcode=?,address=? where username=?";
			for (int i = 1; i < params.length - 1; i++) {
				params[i] = params[i + 1];
			}
			params = Arrays.copyOf(params, params.length - 1);
		} else if (password.equals(password2)) {
			sql = "update userinfo set username=?,password=?,relname=?,phonenumber=?,"
					+ "postalcode=?,address=? where username=?";
		} else {
			// return �������벻��,��jqueryʵ��
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}

		try {
			flag = DaoFactory.getBookDaoInstances().doUpdate(sql, params);
			if (flag) {
				// ���³ɹ�
				// out.println("<script>alert('���³ɹ�')</script>");
				//req.getRequestDispatcher("userInfo.jsp").forward(req, resp);
				resp.sendRedirect("updateSuccess.jsp");
			} else {
				// out.println("<script>alert('���³�ʶ��')</script>");
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