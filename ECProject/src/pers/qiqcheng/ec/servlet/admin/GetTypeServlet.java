package pers.qiqcheng.ec.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import pers.qiqcheng.ec.bean.admin.TypeBean;
import pers.qiqcheng.ec.bean.admin.TypeItemBean;
import pers.qiqcheng.ec.factory.DaoFactory;

public class GetTypeServlet extends HttpServlet{
	public void getTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sql="select typeid,typename from t_goodstype where majorclassid is null";
		String sql2="select typeid,typename from t_goodstype where typeid like ?";
		String params[]={};
		ArrayList<TypeBean> types=new ArrayList<TypeBean>();
		TypeBean typeBean=null;
		ArrayList<TypeItemBean> items=null;
		TypeItemBean item=null;
		HttpSession session=req.getSession();
		try {
			ResultSet rs=DaoFactory.getUserDaoInstances().doSelect(sql, params);
			while(rs.next()){
				typeBean=new TypeBean();
				typeBean.setTypeID(rs.getInt(1));
				typeBean.setTypeName(rs.getString(2));
				items=new ArrayList<TypeItemBean>();
				String params2[]={rs.getInt(1)+"_"};
				ResultSet rs2=DaoFactory.getUserDaoInstances().doSelect(sql2, params2);
				while(rs2.next()){
					item=new TypeItemBean();
					item.setTypeID(rs2.getInt(1));
					item.setTypeName(rs2.getString(2));
					items.add(item);
				}
				typeBean.setItems(items);
				types.add(typeBean);
				
			}
			session.setAttribute("types", types);
			req.getRequestDispatcher("/backend/adminIndex.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String typeName=req.getParameter("tyepName");
		String superTypeName=req.getParameter("superTypeName");
		//out.println(typeName+" "+superTypeName);
		boolean flag=false;
		int newTypeID=0;
		HttpSession session=req.getSession();
		//如果是父类
		ArrayList<TypeBean> types = (ArrayList<TypeBean>) session.getAttribute("types");
		TypeBean typeBean=null;
		if(typeName==null){
			resp.sendRedirect("http://localhost:8080/ECProject/backend/error.jsp");
			return;
		}
		if(superTypeName.length()<1){
			newTypeID=types.size()+1;
			String params[]={newTypeID+"",typeName};
			String sql="insert into t_goodstype(typeid,typename) values(?,?)";
			try {
				flag=DaoFactory.getUserDaoInstances().doInsert(sql, params);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			for(int i=0;i<types.size();i++){
				typeBean=types.get(i);
				if(superTypeName.equals(typeBean.getTypeName())){
					newTypeID=typeBean.getTypeID()*10+typeBean.getItems().size()+1;
					String params[]={newTypeID+"",typeName,typeBean.getTypeID()+""};
					String sql="insert into t_goodstype values(?,?,?)";
					try {
						flag=DaoFactory.getUserDaoInstances().doInsert(sql, params);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		if(flag){
			req.getRequestDispatcher("/backend/getTypes?task=getTypes").forward(req, resp);
		}else {
			resp.sendRedirect("http://localhost:8080/ECProject/backend/error.jsp");
		} 
	}
	public void deleteTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*PrintWriter out=resp.getWriter();
		out.print("delete");*/
		String typeID=req.getParameter("typeID");
		String sql="delete from t_goodstype where typeid=?";
		String params[]={typeID};
		try {
			boolean flag=DaoFactory.getUserDaoInstances().doDelete(sql, params);
			if(flag){
				req.getRequestDispatcher("/backend/getTypes?task=getTypes").forward(req, resp);
			}else {
				resp.sendRedirect("http://localhost:8080/ECProject/backend/error.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		out.print("update");
		String typeID=req.getParameter("typeID");
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String task=req.getParameter("task");
		if("getTypes".equals(task)){
			getTypes(req, resp);
		}else if("addType".equals(task)){
			addTypes(req, resp);
		}else if("deleteType".equals(task)){
			deleteTypes(req, resp);
		}else if("updateType".equals(task)){
			updateTypes(req, resp);
		}else {
			getTypes(req, resp);
		}
	}
	
}
