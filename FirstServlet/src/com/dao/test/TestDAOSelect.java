package com.dao.test;

import java.util.Iterator;
import java.util.List;

import com.dao.dao.proxy.EmpDAOProxy;
import com.dao.factory.DAOFactory;
import com.dao.vo.Emp;

public class TestDAOSelect {
	public static void main(String[] args) throws Exception {
		List<Emp> all=DAOFactory.getIEmpDAOInstance().findAll("");
		Iterator<Emp>it=all.iterator();
		while(it.hasNext()){
			Emp emp=it.next();
			System.out.println(emp.getEmpno()+" "+emp.getEmname()+" "+emp.getJob()+" "+emp.getHiredate()+" "+emp.getSal());
		}	
	}
}