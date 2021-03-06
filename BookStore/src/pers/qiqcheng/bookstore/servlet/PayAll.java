package pers.qiqcheng.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.bookstore.factory.DaoFactory;

public class PayAll extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		resp.setContentType("text/html;charset=utf-8");
		String []confirm=req.getParameterValues("confirm");
		if(confirm==null){
			req.setAttribute("message", "未选择商品或者购物车为空！请将您所需要购买的商品加入购物车，再选择支付");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
			return;
		}
		HttpSession session=req.getSession();
		String username=(String)session.getAttribute("username");
//		PrintWriter out=resp.getWriter();
//		for (String string : confirm) {
//			out.print(string+"\n");
//		}
		int flags=0;
		//更新库存的同时要将购物车中的记录删除
		String sql="update bookinfo set inventory=inventory-1 where isbn=?";
		String sql2="delete from shopcart where username=? and isbn=?";
		for(int i=0;i<confirm.length;i++){
			boolean flag=false,flag2=false;
			String []params={confirm[i]};
			String []params2={username,confirm[i]};
			try {
				flag=DaoFactory.getBookDaoInstances().doUpdate(sql, params);
				flag2=DaoFactory.getBookDaoInstances().doDelete(sql2, params2);
				if(flag&&flag2){
					flags++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(flags==confirm.length){
			req.setAttribute("message", "购买成功！");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("error.jsp");
		}
	}
}
