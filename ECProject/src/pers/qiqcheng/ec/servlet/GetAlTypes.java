package pers.qiqcheng.ec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.ec.factory.DaoFactory;

public class GetAlTypes extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//getTypes
		resp.setContentType("text/json;charset=utf-8") ;
		String action =req.getParameter("action") ;
		PrintWriter out = resp.getWriter() ;		
		if (action.equals("getAll")){
			//查询出大类，以及其子类
			String sql="select a.typeid,a.typename,b.typeid,b.typename from t_goodstype "
					+ "a join t_goodstype b on a.typeid=b.majorclassid";
			String []params={};
			try {
				ResultSet rs=DaoFactory.getUserDaoInstances().doSelect(sql, params);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*Message msgObj = new Message() ;
			msgObj.setSenderName(user);
			msgObj.setSendMsg(msg);
			msgObj.setSendTime(new Date());
			msgList.add(msgObj.toString()) ;
			application.setAttribute("msgList",msgList) ;
			JSONArray jsonarray = JSONArray.fromObject(msgList);
			out.print(jsonarray);
			out.close() ;*/
		} 
	}
	

}
