package com.dao.dao;

import java.util.List;

import com.dao.vo.Emp;

public interface IEmpDao {
	public boolean doCreate(Emp emp)throws Exception;
	public List<Emp> findAll(String keyWord)throws Exception;
	public Emp findByID(int empno)throws Exception;
}
