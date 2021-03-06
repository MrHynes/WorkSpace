package com.dao.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.dao.IEmpDao;
import com.dao.vo.Emp;

public class EmpDAOImpl implements IEmpDao {

	private Connection conn=null;
	private PreparedStatement pstm=null;
	public EmpDAOImpl(Connection conn) {
		this.conn=conn;
	}
	//新增帐户
	@Override
	public boolean doCreate(Emp emp) throws Exception {
		boolean flag=false;
		String sql="insert into emp values(?,?,?,?,?)";
		this.pstm=this.conn.prepareStatement(sql);
		this.pstm.setInt(1, emp.getEmpno());
		this.pstm.setString(2, emp.getEmname());
		this.pstm.setString(3, emp.getJob());
		this.pstm.setDate(4,new java.sql.Date(emp.getHiredate().getTime()));
		this.pstm.setFloat(5, emp.getSal());
		if(this.pstm.executeUpdate()>0){
			flag=true;
		}
		this.conn.close();
		return flag;
	}

	//查询记录
	@Override
	public List<Emp> findAll(String keyWord) throws Exception {
		List<Emp> all=new ArrayList<Emp>();
		String sql="select * from emp where emname like ? or job like ?";
		this.pstm=this.conn.prepareStatement(sql);
		this.pstm.setString(1, "%"+keyWord+"%");
		this.pstm.setString(2, "%"+keyWord+"%");
		ResultSet rs=this.pstm.executeQuery();
		Emp emp=null;
		while(rs.next()){
			emp=new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEmname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setHiredate(rs.getDate(4));
			emp.setSal(rs.getFloat(5));
			all.add(emp);
		}
		this.pstm.close();
		return all;
	}
	//按照编号查询
	@Override
	public Emp findByID(int empno) throws Exception {
		String sql="select * from emp where empno=?";
		this.pstm=this.conn.prepareStatement(sql);
		this.pstm.setInt(1, empno);
		ResultSet rs=this.pstm.executeQuery();
		Emp emp=null;
		while(rs.next()){
			emp=new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEmname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setHiredate(rs.getDate(4));
			emp.setSal(rs.getFloat(5));
		}
		this.pstm.close();
		return emp;
	}
}
