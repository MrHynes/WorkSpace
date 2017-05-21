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

import com.sun.glass.ui.CommonDialogs.Type;

import net.sf.json.JSONArray;
import pers.qiqcheng.ec.bean.TypeBean;
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
		TypeBean typeBean=null;
		List<TypeBean> typeList=new ArrayList<TypeBean>();
		List<String> typeArray=new ArrayList<String>();
		if (action.equals("getAll")){
			//查询出大类，以及其子类
			String sql="select a.typeid,a.typename,b.typeid,b.typename from t_goodstype a "
					+ "left join t_goodstype b on a.typeid=b.majorclassid where a.typeid<10 order by a.typeid,b.typeid";
			//这里有个问题，如果只有大类，没有子类，不会查寻出，所以改成左连接
			String []params={};
			int flags=0;
			try { 
				ResultSet rs=DaoFactory.getUserDaoInstances().doSelect(sql, params);
				while(rs.next()){
					flags=1;
					typeBean=new TypeBean();
					//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)); 
					typeBean.setMajorTypeID(rs.getInt(1));
					typeBean.setMajortypeName(rs.getString(2));
					typeBean.setTypeID(rs.getInt(3));
					typeBean.setTypeName(rs.getString(4));
					typeList.add(typeBean);
				} 
				//flag==1表示成功从表中获取信息
				if(flags==1){
					int flag=0;
					String msg=new String();
					//首先第一条信息
					msg=msg+typeList.get(0).getMajorTypeID()+"@"+typeList.get(0).getMajortypeName()+"&"
							+typeList.get(0).getTypeID()+"@"+typeList.get(0).getTypeName();
					//接下来循环判断当前记录和上一天记录是否是属于同一个大类
					for(int i=1;i<typeList.size();i++){
						//如果是同一个大类
						if(typeList.get(i).getMajorTypeID()==typeList.get(i-1).getMajorTypeID()){
							msg=msg+"&"+typeList.get(i).getTypeID()+"@"+typeList.get(i).getTypeName();
						//如果不是，就将msg保存到list数组中
						}else {
							flag=1;
							typeArray.add(msg);
							msg="";
						}
						if(flag==1){
							//如果是一条完整的记录
							if(typeList.get(i).getTypeName()!=null){
							msg=msg+typeList.get(i).getMajorTypeID()+"@"+typeList.get(i).getMajortypeName()+"&"
									+typeList.get(i).getTypeID()+"@"+typeList.get(i).getTypeName();
							flag=0;
							}else {
								//如果只有大类，没有子类
								msg=msg+typeList.get(i).getMajorTypeID()+"@"+typeList.get(i).getMajortypeName();
								flag=0;
							}
						}
					}
					if(flag==0){
						typeArray.add(msg);
					}
				}else{
					out.print("无类别");
					return;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//序列化为json
			JSONArray jsonarray = JSONArray.fromObject(typeArray);
			out.print(jsonarray);
			out.close();
		} 
	}
	

}
