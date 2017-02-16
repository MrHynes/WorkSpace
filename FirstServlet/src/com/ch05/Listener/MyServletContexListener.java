package com.ch05.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContexListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//web应用停止时
		System.out.println("WebApp destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//web应用启动执行时
		System.out.println("WebApp initialized");
	}

}
