package com.ch05.Listener;

import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountOnlineListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session=se.getSession();
		ServletContext application=session.getServletContext();
		//用hashset集保存所有的session
		HashSet sessions=(HashSet)application.getAttribute("sessions");
		if(sessions==null){
			sessions=new HashSet();
			application.setAttribute("sessions", sessions);
		}
		sessions.add(session);
		application.setAttribute("sessions", sessions);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session=se.getSession();
		ServletContext application=session.getServletContext();
		HashSet sessions=(HashSet)application.getAttribute("sessions");
		if(session!=null){
			sessions.remove(session);
		}
		application.setAttribute("sessions", sessions);
	
	}

}
