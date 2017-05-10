import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.qiqcheng.ec.factory.DaoFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

/**
 * Created by Buer on 2017/5/8.
 */
public class Process extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String user=req.getParameter("user");
        PrintWriter out=resp.getWriter();
        if("".equals(user)||user.length()<6||user.length()>10){
        	out.print("false");
        	return;
        }
        String sql="select * from t_user where suser=?";
        String params[]={user};
       
        try {
			ResultSet rs=DaoFactory.getUserDaoInstances().doSelect(sql, params);
			while(rs.next()){
				out.print("false");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        out.print("true");
    }
}