package com.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		String name=req.getParameter("name");//��ȡ�ͻ����ύ������-����
		String password=req.getParameter("password");//����
		String qpassword=req.getParameter("qpassword");
		String sex=req.getParameter("sex");//�Ա�
		String []hobby=req.getParameterValues("hobby");//����
		String province=req.getParameter("province");//ʡ��
		String introduuce=req.getParameter("introduce");//���
		PrintWriter out=resp.getWriter();
		//�ж���������������Ƿ�һ��
		if(!password.equals(qpassword)){
			out.println("<html><head><title>error!</title></head><body><h1>������������벻һ�£�����������!!</h1></body></html>");
		}
		else {
			out.println("<html>");
			out.println("<head><title>RegisterInfo</title></head>");
			out.println("<body><h1>������ϸ��Ϣ����:<br>");
			out.println("����:"+name+"<br>");
			out.println("����:"+password+"<br>");
			out.println("ȷ������:"+qpassword+"<br>");
			out.println("�Ա�:"+sex+"<br>");
			out.println("����:");
			for (String string : hobby) {
				out.println(string+" ");
			}
			out.println("<br>");
			out.println("ʡ��:"+province+"</br>");
			out.println("���"+introduuce+"<br>");
			out.println("</h1></body></html>");
		}
		out.close();
	}
}
