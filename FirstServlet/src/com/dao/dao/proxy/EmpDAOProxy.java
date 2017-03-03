package com.dao.dao.proxy;

import java.sql.Connection;
import java.util.List;

import com.dao.dao.IEmpDao;
import com.dao.dao.imp.EmpDAOImpl;
import com.dao.dbc.DBconnection;
import com.dao.vo.Emp;

public class EmpDAOProxy implements IEmpDao {

	private DBconnection dbc=null;
	private IEmpDao dao=null;
	
	public EmpDAOProxy() throws Exception {
		this.dbc=new DBconnection();
		this.dao=new EmpDAOImpl(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(Emp emp) throws Exception {
		boolean flag=false;
		if(this.dao.findByID(emp.getEmpno())==null){
			flag=this.dao.doCreate(emp);
		}
		this.dbc.close();
		return flag;
	}

	@Override
	public List<Emp> findAll(String keyWord) throws Exception {
		List<Emp> all=null;
		all=this.dao.findAll(keyWord);
		this.dbc.close();
		return all;
	}

	@Override
	public Emp findByID(int empno) throws Exception {
		Emp emp=null;
		emp=this.dao.findByID(empno);
		this.dbc.close();
		return emp;
	}

}
