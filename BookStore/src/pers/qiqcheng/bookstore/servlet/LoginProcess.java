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
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		// ������ת��ΪMD5��
		String pass = new MD5Code().getMD5ofStr(req.getParameter("password"));
		String sql = "select * from userinfo where username=? and password=?";
		String free = req.getParameter("free");
		String params[] = { username, pass };
		ResultSet rs;
		try {
			rs = DaoFactory.getBookDaoInstances().doSelect(sql, params);
			if (rs.next()) {
				// ����û�����������ȷ��������ʾ��Ʒҳ�棬�����û��������������������
				session.setAttribute("username", username);
				// �����¼ʱ��ѡ�����´��Զ���¼���Ͱ��û���Ϣ���浽cookie
				if (free != null) {
					Cookie cookie = new Cookie(username, pass);
					cookie.setMaxAge(60 * 5);// ����5����
					resp.addCookie(cookie);
				}
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			} else {
				session.setAttribute("username", username);
				resp.sendRedirect("http://localhost:8080/BookStore/login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}