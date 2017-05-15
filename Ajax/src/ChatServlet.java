
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


public class ChatServlet extends HttpServlet {

	
	
	public ChatServlet() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response) ;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=gbk") ;
		String action = request.getParameter("action") ;
		HttpSession session = request.getSession() ;
		ServletContext application = session.getServletContext() ;
		List<String> msgList = (List<String>)application.getAttribute("msgList") ;
		if(msgList==null){
			msgList =new ArrayList<>();
		}
		String update = (String)application.getAttribute("update") ;
		PrintWriter out = response.getWriter() ;
//System.out.println("entering !") ;		
		if (action==null || action.equals("getMsg")) {
			System.out.println("3");
			JSONArray json = JSONArray.fromObject(msgList) ;
			out.write(json.toString());
			out.close() ;
		} else if (action.equals("sendMsg")){
			System.out.println("1");
			String msg = request.getParameter("msg") ;
			String user = (String)session.getAttribute("user") ;
			Message msgObj = new Message() ;
			msgObj.setSenderName(user);
			msgObj.setSendMsg(msg);
			msgObj.setSendTime(new Date());
			System.out.println("msg:"+msgObj.toString()) ;
			msgList.add(msgObj.toString()) ;
			application.setAttribute("msgList",msgList) ;
			JSONArray jsonarray = JSONArray.fromObject(msgList) ;
			out.print(jsonarray);
			out.close() ;
		} else {
			System.out.println("2");
			/*List<Message> msgs = new ArrayList<Message>() ;
			for ( int i=0; i<100; i++) {
				msgs.add(new Message("usr_"+i,"msg_"+i)) ;
			}
			JSONArray jsonArray = JSONArray.fromObject(msgs) ;
			out.println(jsonArray);
			out.close();*/
		}

	}

}
