package pers.qiqcheng.ec.servlet.admin;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.ec.bean.OrderInfoBean;
import pers.qiqcheng.ec.factory.DaoFactory;

public class AdminOrderServlet extends HttpServlet {

	/**
	 * 获得所有订单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("k_username");
		String orderstatus=req.getParameter("k_orderstatus");
		String sql="select orderid,username,ordertime,checker,orderstatus from t_order "
				+ "where username like ? and orderstatus like ?";
		String params[]={"%","%"};
		if(username!=null&&username.length()>0){
			params[0]="%"+username+"%";
		}
		if(orderstatus!=null&&orderstatus.length()>0&&!"请选择订单状态".equals(orderstatus)){
			params[1]=orderstatus;
		}
		/*for (String string : params) {
			System.out.println(string);
		}*/
		List<OrderInfoBean> items=new ArrayList<OrderInfoBean>();
		OrderInfoBean infoBean=null;
		HttpSession session=req.getSession();
		try {
			ResultSet rs=DaoFactory.getUserDaoInstances().doSelect(sql, params);
			while(rs.next()){
				infoBean=new OrderInfoBean();
				infoBean.setOrderID(rs.getString(1));
				infoBean.setUserName(rs.getString(2));
				infoBean.setOrderTime(rs.getString(3));
				infoBean.setChecker(rs.getString(4));
				infoBean.setOrderStatus(rs.getString(5));
				items.add(infoBean);
			}
			session.setAttribute("orders", items);
			req.getRequestDispatcher("/backend/adminOrder.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 审核订单，修改数据库的订单表
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String orderid=req.getParameter("orderid");
		String status=req.getParameter("status");
		if(status==null||"请选择审核状态".equals(status)){
			status="未审核";
		}
		String checker=(String)session.getAttribute("adminName");
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String checkDate=sdf.format(date);
		String params[]={status,checker,checkDate,orderid};
		/*for (String string : params) {
			System.out.println(string);
		}*/
		String sql="update t_order set orderstatus=?,checker=?,checktime=? where orderid=?";
		boolean flag=false;
		try {
			flag=DaoFactory.getUserDaoInstances().doUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			req.getRequestDispatcher("/backend/createOrder?task=showDetailOrder&orderid="+orderid+"&flag=admin").forward(req, resp);
		} else {
			resp.sendRedirect("http://localhost:8080/ECProject/backend/error.jsp");
		}
	}
	/**
	 * 修改订单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	
	public void modifyOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String orderid=req.getParameter("orderid");
		String payment=req.getParameter("payment");
		String sendway=req.getParameter("sendway");
		String receiver=req.getParameter("receiver");
		String address=req.getParameter("address");
		String postcode=req.getParameter("postcode");
		String telephone=req.getParameter("telephone");
		String email=req.getParameter("email");
		boolean flag=false;
		String params[]={payment,sendway,receiver,telephone,email,postcode,address,orderid};
		/*for (String string : params) {
			System.out.println(string);
		}*/
		String sql="update t_order set  payment=?,sendway=?,receiver=?,telephone=?,email=?,postcode=?,address=? where orderid=?";
		try {
			flag=DaoFactory.getUserDaoInstances().doUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			req.getRequestDispatcher("/backend/createOrder?task=showDetailOrder&orderid="+orderid+"&flag=admin").forward(req, resp);
		} else {
			resp.sendRedirect("http://localhost:8080/ECProject/backend/error.jsp");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String task=req.getParameter("task");
		if("getOrders".equals(task)){
			getOrders(req, resp);	
		}else if("checkOrder".equals(task)){
			checkOrder(req, resp);
		}else if("modifyOrder".equals(task)){
			modifyOrder(req, resp);
		}
	}
	

}