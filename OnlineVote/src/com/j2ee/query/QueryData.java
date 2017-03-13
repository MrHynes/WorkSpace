package com.j2ee.query;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j2ee.vo.Info;
import com.j2eeclass.dbConnection.DBConnection;


public class QueryData extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Info info=null;
		List<Info> list=new ArrayList<Info>();
		String sql="select id,name,num from user";
		try {
			conn=new DBConnection().getConnection();
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				info=new Info(rs.getString(1), rs.getString(2), rs.getInt(3));
				list.add(info);
			}
			req.setAttribute("list", list);
			req.getRequestDispatcher("showVote.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}