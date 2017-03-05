package com.dao.test;

import java.util.Iterator;
import java.util.List;

import com.dao.dao.proxy.EmpDAOProxy;
import com.dao.factory.DAOFactory;
import com.dao.vo.Emp;

public class TestDAOSelectByID {
	public static void main(String[] args) throws Exception {
		Emp emp=DAOFactory.getIEmpDAOInstance().findByID(1001);
		System.out.println(emp.getEmpno()+" "+emp.getEmname()+" "+emp.getJob()+" "+emp.getHiredate()+" "+emp.getSal());	
	}
}