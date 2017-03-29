package pers.qiqcheng.onlinechat.servlet;
import pers.qiqcheng.onlinechat.util.MD5Code;
import pers.qiqcheng.onlinechat.factory.DaoFactory;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.ReplicationMySQLConnection;
import com.sun.org.apache.bcel.internal.generic.NEW;


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
		HttpSession session=req.getSession();
		String username=req.getParameter("username");
		//将密码转化为MD5码
		String pass = new MD5Code().getMD5ofStr(req.getParameter("password")) ;
		//String pass=req.getParameter("password");
		String sql="select * from userinfo where username=? and password=?";
		String free=req.getParameter("free");
		String params[]={username,pass};
		ResultSet rs;
		try {
			rs = DaoFactory.getChatDaoInstance().doSelect(sql, params);
			if(rs.next()){
				//如果用户名和密码正确，进入显示投票的页面，并将用户名保存在作用域对象中
				session.setAttribute("users", username);
				if(free!=null){
					Cookie cookie=new Cookie(username, pass);
					cookie.setMaxAge(20);//保存20s
					resp.addCookie(cookie);
				}
				/**
				 * 本来是想用userNum记录登录系统的人数
				 * 后来发现，同一个用户刷新一次浏览器，总人数就加1，次方法不可行.
				 * 所以需要使用一个不允许存放相同元素的set集合存放用户名
				 */
				/*
				ServletContext application=this.getServletContext();
				String userNum=(String)application.getAttribute("userNum");
				if(userNum==null){
					String user="1";
					application.setAttribute("userNum", user);
				}else {
					int num=Integer.parseInt(userNum)+1;
					application.setAttribute("userNum", Integer.toString(num));
				}*/
				/**
				 * 将用户名存到集合，并把集合保存到application，这样通过集合的size()方法就可以获得当前在线人数。
				 * 若有用户退出系统，在exit.jsp页面，将该用户从集合中删除。
				 */
				ServletContext application=this.getServletContext();
				HashSet<String> onlineNum=(HashSet)application.getAttribute("onlineNum");
				if(onlineNum==null){
					Set<String> list=new HashSet<String>();
					list.add(username);
					application.setAttribute("onlineNum", list);
				}else {
					onlineNum.add(username);
					application.setAttribute("onlineNum", onlineNum);
				}
				req.getRequestDispatcher("chatPage.jsp").forward(req, resp);
			}else {
				//HttpSession session=req.getSession();
				session.setAttribute("users", username);
				resp.sendRedirect("http://localhost:8080/OnlineChatting/login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
