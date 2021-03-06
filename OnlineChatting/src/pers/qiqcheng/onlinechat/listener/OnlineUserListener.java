package pers.qiqcheng.onlinechat.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineUserListener implements HttpSessionListener {
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session=se.getSession();
		ServletContext application=session.getServletContext();
		Set<String> onlineUserList=(HashSet)application.getAttribute("onlineUserList");
		String name = (String)session.getAttribute("users");
		//System.out.println("listener");
		onlineUserList.remove(name);
		application.setAttribute("onlineUserList", onlineUserList);
	}

}
