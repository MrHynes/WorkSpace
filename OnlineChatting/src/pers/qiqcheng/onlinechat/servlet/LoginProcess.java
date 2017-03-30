package pers.qiqcheng.onlinechat.servlet;

import pers.qiqcheng.onlinechat.util.MD5Code;
import pers.qiqcheng.onlinechat.factory.DaoFactory;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletContext;
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
		// ��ֹͨ������http://localhost:8080/OnlineChattingloginProcess,Խ����¼���棬����ϵͳ
		if (username == null) {
			resp.sendRedirect("http://localhost:8080/OnlineChatting/login.jsp");
			return;
		}
		// ������ת��ΪMD5��
		String pass = new MD5Code().getMD5ofStr(req.getParameter("password"));
		// String pass=req.getParameter("password");
		String sql = "select * from userinfo where username=? and password=?";
		String free = req.getParameter("free");
		String params[] = { username, pass };
		ResultSet rs;
		try {
			rs = DaoFactory.getChatDaoInstance().doSelect(sql, params);
			if (rs.next()) {
				// ����û�����������ȷ��������ʾͶƱ��ҳ�棬�����û��������������������
				session.setAttribute("users", username);
				// �����¼ʱ��ѡ�����´��Զ���¼���Ͱ��û���Ϣ���浽cookie
				if (free != null) {
					Cookie cookie = new Cookie(username, pass);
					cookie.setMaxAge(60 * 5);// ����5����
					resp.addCookie(cookie);
				}
				/**
				 * ����������userNum��¼��¼ϵͳ������ �������֣�ͬһ���û�ˢ��һ����������������ͼ�1���÷���������.
				 * ������Ҫʹ��һ�������������ͬԪ�ص�set���ϴ���û���
				 */
				/*
				 * ServletContext application=this.getServletContext(); String
				 * userNum=(String)application.getAttribute("userNum");
				 * if(userNum==null){ String user="1";
				 * application.setAttribute("userNum", user); }else { int
				 * num=Integer.parseInt(userNum)+1;
				 * application.setAttribute("userNum", Integer.toString(num)); }
				 */
				/**
				 * ���û����浽HashSet���ϣ����Ѽ��ϱ��浽application������ͨ�����ϵ�size()�����Ϳ��Ի�õ�ǰ����������
				 * �����û��˳�ϵͳ����exit.jspҳ�棬�����û��Ӽ�����ɾ����
				 */
				ServletContext application = this.getServletContext();
				HashSet<String> onlineUserList = (HashSet) application.getAttribute("onlineUserList");
				if (onlineUserList == null) {
					Set<String> list = new HashSet<String>();
					list.add(username);
					application.setAttribute("onlineUserList", list);
				} else {
					onlineUserList.add(username);
					application.setAttribute("onlineUserList", onlineUserList);
				}
				req.getRequestDispatcher("chatPage.jsp").forward(req, resp);
			} else {
				session.setAttribute("users", username);
				resp.sendRedirect("http://localhost:8080/OnlineChatting/login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}