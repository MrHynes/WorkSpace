package com.j2ee.update;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j2eeclass.dbConnection.DBConnection;

public class UpdateData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstm = null;
		String id = req.getParameter("id");
		int num = Integer.parseInt(req.getParameter("num"));
		String sql = "update user set num=? where id=?";
		try {
			conn = new DBConnection().getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, num+1);
			pstm.setString(2, id);
			pstm.executeUpdate();
			req.getRequestDispatcher("query").forward(req, resp);
			/*
			if (pstm.executeUpdate() > 0) {
				req.getRequestDispatcher("showVote.jsp").forward(req, resp);
			} else {
				resp.sendRedirect("error.jsp");
			}
			*/

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}