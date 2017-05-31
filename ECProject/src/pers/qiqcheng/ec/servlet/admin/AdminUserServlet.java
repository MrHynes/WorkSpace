package pers.qiqcheng.ec.servlet.admin;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qiqcheng.ec.bean.UserBean;
import pers.qiqcheng.ec.factory.DaoFactory;

public class AdminUserServlet extends HttpServlet {
	/**
	 * 查询所有的注册用户，可以按照用户名，性别，和状态分类查询用户
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username=req.getParameter("k_username");
		String sex=req.getParameter("k_sex");
		String status=req.getParameter("k_status");
		String params[]={"%","%","%"};
		//如果username是不为空，或者长度大于0.将获取的查询关键字赋给params数组
		if(username!=null&&username.length()>0){
			params[0]="%"+username+"%";
		}
		if(sex!=null&&!"请选择性别".equals(sex)){
			params[1]=sex;
		}
		if(status!=null&&!"请选择状态".equals(status)){
			params[2]=status;
		}
		/*for (String string : params) {
			System.out.println(string);
		}*/
		String sql="select username,relname,sex,joindate,status from t_user"
				+ " where username like ? and sex like ? and status like ?";
		ArrayList<UserBean> items=new ArrayList<UserBean>();
		UserBean userBean=null;
		HttpSession session=req.getSession();
		try {
			//查询满足条件的注册用户，保存在集合中
			ResultSet rs=DaoFactory.getUserDaoInstances().doSelect(sql, params);
			while(rs.next()){
				userBean=new UserBean();
				userBean.setUserName(rs.getString(1));
				userBean.setRelName(rs.getString(2));
				userBean.setSex(rs.getString(3));
				userBean.setJoniDate(rs.getDate(4));
				userBean.setStatus(rs.getInt(5));
				items.add(userBean);
			}
			//将集合保存在session中
			session.setAttribute("userItems", items);
			req.getRequestDispatcher("/backend/adminUser.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 冻结账户
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void accountFreeze(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//获得需要冻结账户的帐户名
		String username=req.getParameter("username");
		boolean flag=false;
		//使用sql语句执行更新操作
		if(username!=null){
			String sql="update t_user set status=1 where username=?";
			String params[]={username};
			try {
				flag=DaoFactory.getUserDaoInstances().doUpdate(sql, params);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(flag){
			req.getRequestDispatcher("/backend/admUser?task=getUser").forward(req, resp);
		}else {
			resp.sendRedirect("http://localhost:8080/ECProject/backend/error.jsp");
		} 
	}
	public void searchUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String task=req.getParameter("task");
		if("getUser".equals(task)){
			getUsers(req, resp);
		}else if("acountFreeze".equals(task)){
			accountFreeze(req, resp);
		}
	}
	

}
