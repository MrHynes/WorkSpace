package com.dao.test;

import java.util.Date;

import com.dao.factory.DAOFactory;
import com.dao.vo.Emp;

public class TestDAOInsert {
	public static void main(String[] args) throws Exception {
		Emp emp=null;
		for(int i=0;i<5;i++){
			emp=new Emp();
			emp.setEmpno(1000+i);
			emp.setEmname("chengqi-"+i);
			emp.setJob("teacher-"+i);
			emp.setHiredate(new Date());
			emp.setSal(5000*i);
			DAOFactory.getIEmpDAOInstance().doCreate(emp);
		}
	}

}