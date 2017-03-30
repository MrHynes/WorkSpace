package pers.qiqcheng.onlinechat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.onlinechat.bean.Message;

public class GetMsg extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String msg=req.getParameter("msg");
		HttpSession session=req.getSession();
		String name=(String)session.getAttribute("users");
		ServletContext application=this.getServletContext();
		//获取用户发送的信息，保存在message对象中
		Message message=new Message();
		message.setSenderName(name);
		message.setSendMsg(msg);
		message.setSendTime(new Date());
		List<Message> msgList=(List<Message>)application.getAttribute("msgList");
		//将message对象保存到集合msgList，然后msgList保存在application
		if(msgList==null){
			List<Message> list=new ArrayList<Message>();
			list.add(message);
			application.setAttribute("msgList", list);
		}else {
			msgList.add(message);
			application.setAttribute("msgList", msgList);
		}
		/*
		PrintWriter out=resp.getWriter();
		for (Message message2 : msgList) {
			out.println(message2.getSenderName()+" "+message2.getSendMsg()+" "+message2.getSendTime());
		}
		*/
		req.getRequestDispatcher("chatPage.jsp").forward(req, resp);
	}

}
