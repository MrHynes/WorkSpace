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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pers.qiqcheng.onlinechat.bean.Message;

public class GetMsg extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String msg=req.getParameter("msg");
		HttpSession session=req.getSession();
		String name=(String)session.getAttribute("users");
		ServletContext application=this.getServletContext();
		//��ȡ�û����͵���Ϣ��������message������
		Message message=new Message();
		message.setSenderName(name);
		message.setSendMsg(msg);
		message.setSendTime(new Date());
		List<Message> msgList=(List<Message>)application.getAttribute("msgList");
		//��message���󱣴浽����msgList��Ȼ��msgList������application
		if(msgList==null){
			List<Message> list=new ArrayList<Message>();
			list.add(message);
			application.setAttribute("msgList", list);
		}else {
			msgList.add(message);
			application.setAttribute("msgList", msgList);
		}
		for (Message message2 : msgList) {
			System.out.println(message2.toString());
		}
		req.getRequestDispatcher("chatPage.jsp").forward(req, resp);*/
		resp.setContentType("text/json;charset=utf-8") ;
		String action =req.getParameter("action") ;
		String msg = req.getParameter("msg") ;
		HttpSession session = req.getSession() ;
		ServletContext application = session.getServletContext() ;
		List<String> msgList = (List<String>)application.getAttribute("msgList") ;
		if(msgList==null){
			msgList =new ArrayList<>();
		}
		PrintWriter out = resp.getWriter() ;		
		if (action==null || action.equals("getMsg")) {
			JSONArray json = JSONArray.fromObject(msgList) ;
			out.write(json.toString());
			out.close() ;
		} else if (action.equals("sendMsg")){
			String user = (String)session.getAttribute("users") ;
			Message msgObj = new Message() ;
			msgObj.setSenderName(user);
			msgObj.setSendMsg(msg);
			msgObj.setSendTime(new Date());
			msgList.add(msgObj.toString()) ;
			application.setAttribute("msgList",msgList) ;
			JSONArray jsonarray = JSONArray.fromObject(msgList);
			out.print(jsonarray);
			out.close() ;
		} 
	}

}
