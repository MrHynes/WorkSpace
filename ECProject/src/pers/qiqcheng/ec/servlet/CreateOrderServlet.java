package pers.qiqcheng.ec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.ezmorph.array.ObjectArrayMorpher;
import pers.qiqcheng.ec.bean.CartBean;
import pers.qiqcheng.ec.bean.CartItemBean;
import pers.qiqcheng.ec.bean.OrderBean;
import pers.qiqcheng.ec.bean.OrderItemBean;
import pers.qiqcheng.ec.bean.ShowOrderBean;
import pers.qiqcheng.ec.factory.DaoFactory;

public class CreateOrderServlet extends HttpServlet{

	public void getOrderGoodsId(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		//获取勾选的商品的值-即商品id
		String goodID=req.getParameter("check");
		String []goodIDs=goodID.split(",");
		HttpSession session=req.getSession();
		//session.setAttribute("order", goodIDs);
		//获取当前用户名
		String username=(String)session.getAttribute("username");
		//获取购物车
		CartBean cartBean=CartBean.getCartBean(session);
		List<CartItemBean> items=cartBean.getItems();
		List<OrderItemBean> itemsOrder=new ArrayList<OrderItemBean>();
		OrderItemBean orderItemBean=null;
		//int count=0;
		//float totalPrice=0.0f;
		//将被勾选的商品的 单价数量等信息保存在orderItemBean中
		for (CartItemBean cartItemBean : items) {
			for(int i=0;i<goodIDs.length;i++){
				if(goodIDs[i].equals(cartItemBean.getGoodID())){
					orderItemBean=new OrderItemBean();
					orderItemBean.setGoodId(goodIDs[i]);
					orderItemBean.setCount(cartItemBean.getCount());
					orderItemBean.setGoodsPrice(cartItemBean.getTotalPrice());
					itemsOrder.add(orderItemBean);
					/*count+=cartItemBean.getCount();
					totalPrice+=cartItemBean.getTotalPrice();*/
				}
			}
		}
		//计算出现在订单中的商品种类数和商品总数，以及价格等，保存在orderBean中
		OrderBean orderBean=new OrderBean();
		orderBean.setItems(itemsOrder);
		orderBean.setCount(cartBean.getCount());
		orderBean.setTypeCount(goodIDs.length);
		orderBean.setTotalPrice(cartBean.getTotalPrice());
		orderBean.setOrderID(username);
		session.setAttribute("orderBean", orderBean);
		req.getRequestDispatcher("/frontend/order.jsp").forward(req, resp);
	}
	//点击确认下单，生成订单，并存储到数据库中，然后将选购的商品从session中删除
	public void insertIntoTable(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		//获取下单页面用户输入的信息
		HttpSession session=req.getSession();
		String userName=(String)session.getAttribute("username");
		String orderId=req.getParameter("orderid");
		String orderTime=req.getParameter("orderdate");
		String payMent=req.getParameter("parment");
		String sendWay=req.getParameter("sendway");
		String receiver=req.getParameter("relname");
		String address=req.getParameter("address");
		String postCode=req.getParameter("postcode");
		String telePhone=req.getParameter("telephone");
		String email=req.getParameter("email");
		//插入订单表
		String sql="insert into t_order(orderid,username,ordertime,payment, sendway,receiver,telephone,email,postcode,address)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		String []params={orderId,userName,orderTime,payMent,sendWay,receiver,telePhone,email,postCode,address};
		try {
			boolean flag=DaoFactory.getUserDaoInstances().doInsert(sql, params);
			//如果插入成功，就继续将订单明细插入数据库，还需要将下单后的商品从购物车中删除,同时需要更新商品库存
			if(flag){
				OrderBean orderBean=(OrderBean)session.getAttribute("orderBean");
				String orderID=orderBean.getOrderID();
				String sql2="insert into t_order_detail values(?,?,?,?)";
				String sql3="update t_goods set inventory=inventory-? where goodid=?";
				List<OrderItemBean> itemBeans=orderBean.getItems();
				for (OrderItemBean orderItemBean : itemBeans) {
					String params2[]={orderID,orderItemBean.getGoodId(),orderItemBean.getCount()+"",orderItemBean.getGoodsPrice()+""};
					DaoFactory.getUserDaoInstances().doInsert(sql2, params2);
					//更新库存
					String params3[]={orderBean.getCount()+"",orderItemBean.getGoodId()};
					DaoFactory.getUserDaoInstances().doUpdate(sql3, params3);
					//将商品从购物车中删除
					CartBean cartBean=CartBean.getCartBean(session);
					List<CartItemBean> items=cartBean.getItems();
					for(int i=0;i<items.size();i++){
						if(items.get(i).getGoodID().equals(orderItemBean.getGoodId())){
							items.remove(i);
						}
					}
				}
				req.getRequestDispatcher("/frontend/createOrder?task=showOrders").forward(req, resp);
			}else {
				resp.sendRedirect("/common/error.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 查看订单
	 */
	public void showOrders(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		String sql=" select t_order.orderid,ordertime,orderstatus,sum(num),sum(goodprice)  "
				+ "from t_order,t_order_detail where username=? and t_order.orderid=t_order_detail.orderid "
				+ "group by orderid;";
		HttpSession session=req.getSession();
		String username=(String)session.getAttribute("username");
		ShowOrderBean showOrderBean=null;
		List<ShowOrderBean> order=new ArrayList<ShowOrderBean>();
		String parmas[]={username};
		try {
			ResultSet rs=DaoFactory.getUserDaoInstances().doSelect(sql, parmas);
			while(rs.next()){
				showOrderBean=new ShowOrderBean();
				showOrderBean.setOrderId(rs.getString(1));
				showOrderBean.setOrderTime(rs.getString(2));
				showOrderBean.setOrderStatus(rs.getString(3));
				showOrderBean.setSum(rs.getInt(4));
				showOrderBean.setTotalPrice(rs.getFloat(5));
				order.add(showOrderBean);
			}
			session.setAttribute("order", order);
			req.getRequestDispatcher("/frontend/revieworder.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void directBuy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String goodID=req.getParameter("goodid");
		float price =Float.parseFloat(req.getParameter("price"));
		int num=1;
		if(req.getParameter("num")!=null){
			num=Integer.parseInt(req.getParameter("num"));
		}
		HttpSession session=req.getSession();
		String username=(String)session.getAttribute("username");
		/*PrintWriter out=resp.getWriter();
		out.println(goodID);
		out.print(price);*/
		List<OrderItemBean> itemsOrder=new ArrayList<OrderItemBean>();
		OrderItemBean orderItemBean=new OrderItemBean();
		orderItemBean.setCount(num);
		orderItemBean.setGoodId(goodID);
		orderItemBean.setGoodsPrice(price);
		itemsOrder.add(orderItemBean);
		OrderBean orderBean=new OrderBean();
		orderBean.setItems(itemsOrder);
		orderBean.setCount(num);
		orderBean.setTypeCount(1);
		orderBean.setTotalPrice(price*num);
		orderBean.setOrderID(username);
		session.setAttribute("orderBean", orderBean);
		req.getRequestDispatcher("/frontend/order.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String task=req.getParameter("task");
		if("getID".equals(task)){
			getOrderGoodsId(req, resp);
		}else if("insertTable".equals(task)){
			insertIntoTable(req,resp);
		}else if("showOrders".equals(task)){
			showOrders(req, resp);
		}else if("directBuy".equals(task)) {
			directBuy(req, resp);
		}
	}

}
