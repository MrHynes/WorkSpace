package com.dbop.dao;

import java.sql.ResultSet;
import java.util.List;

import com.dbop.vo.Info;

public interface IDbopDao {
	public boolean doInsert(Info info) throws Exception;
	public List<Info> doSelect() throws Exception;
	public Info doSelectByKey(String key) throws Exception;
	public boolean doDelete(String key)throws Exception;
	public boolean doUpdate(Info info)throws Exception;
}
