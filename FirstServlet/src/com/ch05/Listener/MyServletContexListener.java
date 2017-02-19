package com.ch05.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContexListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//webӦ��ֹͣʱ
		System.out.println("WebApp destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//webӦ������ִ��ʱ
		System.out.println("WebApp initialized");
	}

}